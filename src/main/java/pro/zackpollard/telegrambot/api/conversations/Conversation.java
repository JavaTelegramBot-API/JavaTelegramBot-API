package pro.zackpollard.telegrambot.api.conversations;

import lombok.Getter;
import lombok.Setter;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.Content;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.util.*;

/**
 * This object represents a conversation between the bot and a chat.
 * A conversation is a structure of prompts/messages that follow with a user.
 *
 * @author Mazen Kotb
 * @see Conversation#builder(TelegramBot)
 */
public final class Conversation {
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
     * The prompts to be called during the conversation, do not attempt to modify this list.
     * Is processed through Collections.unmodifiableList
     *
     * @see Collections#unmodifiableList(List)
     */
    @Getter
    private final List<ConversationPrompt> prompts;

    private Conversation(TelegramBot bot, Map<String, Object> sessionData, Chat forWhom, boolean silent,
                        boolean disableGlobalEvents, List<ConversationPrompt> prompts) {
        this.forWhom = forWhom;
        this.context = new ConversationContext(this, bot, sessionData);
        this.currentPrompt = prompts.get(promptIndex);
        this.prompts = Collections.unmodifiableList(prompts);
        this.silent = silent;
        this.disableGlobalEvents = disableGlobalEvents;
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
        context.getBot().getConversationRegistry().registerConversation(this);

        if (!silent) {
            SendableMessage response = currentPrompt.promptMessage(context);

            if (response != null) {
                forWhom.sendMessage(response);
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
     * @see Conversation#end()
     */
    public void accept(Message message) {
        Content content = message.getContent();

        if (content.getType() != currentPrompt.type()) {
            return;
        }


        if (!currentPrompt.process(context, content)) {
            if (promptIndex + 1 == prompts.size()) {
                end();
                return;
            }

            currentPrompt = prompts.get(++promptIndex);
        }

        SendableMessage promptMessage = currentPrompt.promptMessage(context);

        if (!silent && promptMessage != null) {
            forWhom.sendMessage(promptMessage);
        }

        context.getHistory().history.add(message);
    }

    /**
     * Calls the conversation end method of the current prompt, and removes conversation
     * from registry.
     *
     * @see ConversationPrompt#conversationEnded(ConversationContext)
     */
    public void end() {
        if (currentPrompt != null) {
            currentPrompt.conversationEnded(context);
            currentPrompt = null;
        }

        context.getBot().getConversationRegistry().removeConversation(this);
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

        ConversationBuilder(TelegramBot bot) {
            this.bot = bot;
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

        public Conversation build() {
            Utils.validateNotNull(bot, forWhom, prompts);
            return new Conversation(bot, sessionData, forWhom, silent, disableGlobalEvents,
                    prompts);
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
