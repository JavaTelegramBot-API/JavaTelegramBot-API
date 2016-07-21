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

public final class Conversation {
    private int promptIndex = 0;
    @Getter
    private final ConversationContext context;
    @Getter
    private final Chat forWhom;
    @Setter
    @Getter
    private boolean silent;
    @Setter
    @Getter
    private boolean disableGlobalEvents;
    @Getter
    private ConversationPrompt currentPrompt;
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

    public static ConversationBuilder builder(TelegramBot bot) {
        return new ConversationBuilder(bot);
    }

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

    public void end() {
        if (currentPrompt != null) {
            currentPrompt.conversationEnded(context);
            currentPrompt = null;
        }

        context.getBot().getConversationRegistry().removeConversation(this);
    }

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

        public ConversationBuilder forWhom(Chat chat) {
            this.forWhom = chat;
            return this;
        }

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

    public static class PromptsBuilder {
        private final List<ConversationPrompt> prompts = new ArrayList<>();
        private final ConversationBuilder conversationBuilder;

        private PromptsBuilder(ConversationBuilder conversationBuilder) {
            this.conversationBuilder = conversationBuilder;
        }

        public PromptsBuilder first(ConversationPrompt prompt) {
            prompts.clear();
            return then(prompt);
        }

        public PromptsBuilder then(ConversationPrompt prompt) {
            prompts.add(prompt);
            return this;
        }

        public ConversationBuilder last(ConversationPrompt prompt) {
            prompts.add(prompt);
            return end();
        }

        public ConversationBuilder end() {
            conversationBuilder.prompts = prompts;
            return conversationBuilder;
        }
    }
}
