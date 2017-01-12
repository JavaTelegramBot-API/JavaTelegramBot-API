package pro.zackpollard.telegrambot.api.conversations;

import lombok.Getter;
import lombok.Setter;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.Content;
import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.extensions.Extensions;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableTextMessage;
import pro.zackpollard.telegrambot.api.user.User;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * This object represents a conversation between the bot and a chat.
 * A conversation is a structure of prompts/messages that follow with a user.
 *
 * @author Mazen Kotb
 * @see Conversation#builder(TelegramBot)
 */
public final class Conversation {
    private static final Timer TIMER = new Timer();
    /**
     * The index of the current prompt. Starts from 0 like an array index.
     * If promptIndex + 1 == prompt.size, there are no further prompts
     *
     * @see Conversation#prompts
     */
    private int promptIndex = 0;
    /**
     * Context data of the conversation
     */
    @Getter
    private final ConversationContext context;
    /**
     * The other participant of the conversation
     */
    @Getter
    private final Chat forWhom;
    /**
     * If true, the promptMessage method will not be called.
     * Thus no messages will be sent in response to user input
     *
     * @see ConversationPrompt#promptMessage(ConversationContext)
     */
    @Setter
    @Getter
    private boolean silent;
    /**
     * If true, no events will be called from this chat until the conversation has ended.
     */
    @Setter
    @Getter
    private boolean disableGlobalEvents;
    /**
     * The current prompt. Matches with promptIndex
     *
     * @see Conversation#promptIndex
     */
    @Getter
    private ConversationPrompt currentPrompt;
    /**
     * Has the conversation ended yet?
     */
    @Getter
    private boolean virgin = true;
    /**
     * The prompts to be called during the conversation, do not attempt to modify this list.
     * Is processed through Collections.unmodifiableList
     *
     * @see Collections#unmodifiableList(List)
     */
    @Getter
    private final List<ConversationPrompt> prompts;
    /**
     * Only listens for certain users based on the predicate
     */
    private final Predicate<User> userPredicate;
    /**
     * Forces all messages that are processed by the conversation to be replies
     */
    private final boolean repliesOnly;
    /**
     * Executed when the conversation is ended for somewhatever reason.
     * Regardless of the current prompt.
     */
    private final BiConsumer<Conversation, ConversationContext> endCallback;
    /**
     * Called with every input, if returns true, the conversation will be ended.
     */
    private final BiPredicate<ConversationContext, Content> endPredicate;

    private Conversation(TelegramBot bot, Map<String, Object> sessionData, Chat forWhom, boolean silent,
                        boolean disableGlobalEvents, List<ConversationPrompt> prompts,
                         Predicate<User> userPredicate, boolean repliesOnly,
                         BiConsumer<Conversation, ConversationContext> endCallback,
                         BiPredicate<ConversationContext, Content> endPredicate,
                         long timeout, SendableMessage timeoutMessage) {
        this.forWhom = forWhom;
        this.context = new ConversationContext(this, bot, sessionData);
        this.currentPrompt = prompts.get(promptIndex);
        this.prompts = Collections.unmodifiableList(prompts);
        this.silent = silent;
        this.disableGlobalEvents = disableGlobalEvents;
        this.userPredicate = (userPredicate == null) ? (user) -> true : userPredicate;
        this.repliesOnly = repliesOnly;
        this.endCallback = endCallback;
        this.endPredicate = endPredicate;

        if (timeout > 0) {
            TIMER.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (isVirgin()) {
                        if (timeoutMessage != null) {
                            sendMessage(timeoutMessage);
                        }

                        end();
                    }
                }
            }, TimeUnit.SECONDS.toMillis(timeout));
        }
    }

    /**
     * Creates a builder for a conversation
     * @param bot The bot which you wish to use for the conversation
     * @return a new conversation builder
     */
    public static ConversationBuilder builder(TelegramBot bot) {
        return new ConversationBuilder(bot);
    }

    /**
     * Initiates the conversation with the first prompt, registers the conversation in the registry.
     *
     * @return The current conversation
     */
    public Conversation begin() {
        if (!virgin) {
            throw new IllegalStateException("You can only start a virgin conversation!");
        }

        Extensions.get(context.getBot(), ConversationRegistry.class).registerConversation(this);

        if (!silent) {
            SendableMessage response = currentPrompt.promptMessage(context);

            if (response != null) {
                sendMessage(response);
            }
        }

        return this;
    }

    /**
     * Send internally; uses message to process the prompt, and move on to the next one.
     * Calls the end() method if there are no further prompts.
     * Do not call unless you understand what you're doing.
     *
     * @param message The message to be processed
     * @return If the message prompted a prompt
     * @see Conversation#end()
     */
    public boolean accept(Message message) {
        Content content = message.getContent();

        if (!userPredicate.test(message.getSender())) {
            return false;
        }

        if (endPredicate != null && endPredicate.test(context, content)) {
            end();
            return true;
        }

        if (content.getType() != currentPrompt.type()) {
            return false;
        }

        if (repliesOnly) {
            Message repliedTo = message.getRepliedTo();

            if (repliedTo == null || repliedTo.getSender().getUsername().equals(context.getBot().getBotUsername())) {
                return false;
            }
        }

        if (!currentPrompt.process(context, content)) {
            if (promptIndex + 1 == prompts.size()) {
                end();
                return true;
            }

            currentPrompt = prompts.get(++promptIndex);
        }

        SendableMessage promptMessage = currentPrompt.promptMessage(context);

        if (!silent && promptMessage != null) {
            sendMessage(promptMessage);
        }

        context.getHistory().history.add(message);
        return true;
    }

    /**
     * Calls the conversation end method of the current prompt, and removes conversation
     * from registry.
     *
     * @see ConversationPrompt#conversationEnded(ConversationContext)
     */
    public void end() {
        if (endCallback != null) {
            endCallback.accept(this, context);
        }

        if (currentPrompt != null) {
            currentPrompt.conversationEnded(context);
            currentPrompt = null;
        }

        Extensions.get(context.getBot(), ConversationRegistry.class).removeConversation(this);
        virgin = false;
    }

    private void sendMessage(SendableMessage message) {
        context.getHistory().sentMessages.add(forWhom.sendMessage(message).getMessageId());
    }

    /**
     * The builder used to create conversations. forWhom() and prompts() must be called before building
     *
     * @author Mazen Kotb
     * @see ConversationBuilder#forWhom(Chat)
     * @see ConversationBuilder#prompts()
     */
    public static class ConversationBuilder {
        private final TelegramBot bot;
        private Chat forWhom;
        private List<ConversationPrompt> prompts = null;
        private Map<String, Object> sessionData = new HashMap<>();
        private boolean silent;
        private boolean disableGlobalEvents;
        private boolean repliesOnly = false;
        private Predicate<User> userPredicate;
        private BiConsumer<Conversation, ConversationContext> endCallback;
        private BiPredicate<ConversationContext, Content> endPredicate;
        private long timeout = -1;
        private SendableMessage timeoutMessage;

        ConversationBuilder(TelegramBot bot) {
            this.bot = bot;
        }

        /**
         * Timeout in seconds for the conversation to be finished.
         * If the conversation is not finished, it will be ended.
         *
         * @param timeout Timeout in seconds
         */
        public ConversationBuilder conservationTimeout(long timeout) {
            return conversationTimeout(timeout, null);
        }

        /**
         * Timeout in seconds for the conversation to be finished.
         * If the conversation is not finished, it will be ended and the message provided will be sent.
         *
         * @param timeout Timeout in seconds
         * @param message Message to be sent if the conversation is timed out
         */
        public ConversationBuilder conversationTimeout(long timeout, SendableMessage message) {
            this.timeout = timeout;
            this.timeoutMessage = message;
            return this;
        }

        public ConversationBuilder endCommand(String command) {
            return endText(command.charAt(0) == '/' ? command : "/" + command);
        }

        public ConversationBuilder endText(String text) {
            return endText(text, true);
        }

        public ConversationBuilder endText(String text, boolean ignoreCase) {
            return endText((string) -> ignoreCase ? text.equalsIgnoreCase(string) : text.equals(string));
        }

        /**
         * Called with every input, if returns true, the conversation will be ended.
         */
        public ConversationBuilder endText(Predicate<String> textPredicate) {
            return endPredicate((context, content) -> content instanceof TextContent &&
                    textPredicate.test(((TextContent) content).getContent()));
        }

        public ConversationBuilder endPredicate(BiPredicate<ConversationContext, Content> predicate) {
            this.endPredicate = predicate;
            return this;
        }

        /**
         * The message that is sent when the conversation ends.
         *
         * Not to be confused with endText which is the text that if sent by the user,
         * the conversation will be ended.
         *
         * @param message Message to be sent when the conversation ends.
         * @return Current Builder
         */
        public ConversationBuilder endingMessage(SendableTextMessage message) {
            return endCallback((conv, context) -> conv.sendMessage(message));
        }

        public ConversationBuilder endCallback(BiConsumer<Conversation, ConversationContext> callback) {
            this.endCallback = callback;
            return this;
        }

        /**
         * Mandatory. Set the other participant in the conversation
         * @param chat The other participant
         * @return Current builder
         */
        public ConversationBuilder forWhom(Chat chat) {
            this.forWhom = chat;
            return this;
        }

        /**
         * Mandatory to be completely processed. Creates a new prompt builder.
         *
         * @return new prompt builder
         * @see PromptsBuilder#end()
         * @see PromptsBuilder#last(ConversationPrompt)
         */
        public PromptsBuilder prompts() {
            return new PromptsBuilder(this);
        }

        public ConversationBuilder sessionData(Map<String, Object> data) {
            this.sessionData = data;
            return this;
        }

        public ConversationBuilder silent(boolean silent) {
            this.silent = silent;
            return this;
        }

        public ConversationBuilder disableGlobalEvents(boolean disableGlobalEvents) {
            this.disableGlobalEvents = disableGlobalEvents;
            return this;
        }

        public ConversationBuilder repliesOnly(boolean value) {
            this.repliesOnly = value;
            return this;
        }

        /**
         * Add a user filter to the conversation.
         * Predicate is called before any prompts are called, if returned true
         * the prompts will be called, otherwise it won't
         *
         * @param predicate user filter
         * @return this
         */
        public ConversationBuilder userFilter(Predicate<User> predicate) {
            this.userPredicate = predicate;
            return this;
        }

        /**
         * Allow a list of users to be part of this conversation
         * @param users Allowed users
         * @return this
         */
        public ConversationBuilder allowedUsers(User... users) {
            List<User> usersList = Arrays.asList(users);
            this.userPredicate = (user) -> usersList.stream()
                    .anyMatch((allowedUser) -> allowedUser.getId() == user.getId());
            return this;
        }

        /**
         * Allow a single user to be part of this conversation
         * @param allowedUser allowed user
         * @return this
         */
        public ConversationBuilder allowedUser(User allowedUser) {
            this.userPredicate = (user) -> user.getId() == allowedUser.getId();
            return this;
        }

        /**
         * Allow a list of users to be part of this conversation
         * @param userIds allows user ids
         * @return this
         */
        public ConversationBuilder allowedUsers(long... userIds) {
            this.userPredicate = (user) -> {
                for (long id : userIds) {
                    if (id == user.getId()) {
                        return true;
                    }
                }

                return false;
            };
            return this;
        }

        /**
         * Allow a single user to use be part of conversation
         * @param userId the id of said user
         * @return this
         */
        public ConversationBuilder allowedUser(long userId) {
            this.userPredicate = (user) -> user.getId() == userId;
            return this;
        }

        public Conversation build() {
            Utils.validateNotNull(bot, forWhom, prompts);
            return new Conversation(bot, sessionData, forWhom, silent, disableGlobalEvents,
                    prompts, userPredicate, repliesOnly, endCallback, endPredicate,
                    timeout, timeoutMessage);
        }
    }

    /**
     * A builder for prompts
     *
     * @author Mazen Kotb
     */
    public static class PromptsBuilder {
        private final List<ConversationPrompt> prompts = new ArrayList<>();
        private final ConversationBuilder conversationBuilder;

        private PromptsBuilder(ConversationBuilder conversationBuilder) {
            this.conversationBuilder = conversationBuilder;
        }

        /**
         * Clears all previous prompts and adds 'prompt' as the head of the stack.
         * @param prompt The initial prompt
         * @return Current builder
         */
        public PromptsBuilder first(ConversationPrompt prompt) {
            prompts.clear();
            return then(prompt);
        }

        /**
         * Adds a prompt to the stack
         * @param prompt Next prompt
         * @return Current builder
         */
        public PromptsBuilder then(ConversationPrompt prompt) {
            prompts.add(prompt);
            return this;
        }

        /**
         * Adds the foot to the stack, and completes the build
         * @param prompt Final prompt
         * @return Conversation builder initialized with
         */
        public ConversationBuilder last(ConversationPrompt prompt) {
            prompts.add(prompt);
            return end();
        }

        /**
         * Ends the prompt building and uses last prompt as the foot of the stack
         * @return Conversation builder initialized with
         */
        public ConversationBuilder end() {
            conversationBuilder.prompts = prompts;
            return conversationBuilder;
        }
    }
}
