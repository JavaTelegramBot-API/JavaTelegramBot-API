package pro.zackpollard.telegrambot.api.conversations;

import lombok.Setter;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.Content;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public final class Conversation {
    private final ConversationContext context;
    private final Chat forWhom;
    @Setter
    private boolean silent;
    @Setter
    private boolean disableGlobalEvents;
    private ConversationPrompt currentPrompt;
    private final ConversationPrompt initialPrompt;

    private Conversation(TelegramBot bot, Map<String, Object> sessionData, Chat forWhom, boolean silent,
                        boolean disableGlobalEvents, ConversationPrompt currentPrompt, ConversationPrompt initialPrompt) {
        this.context = new ConversationContext(this, bot, sessionData);
        this.forWhom = forWhom;
        this.currentPrompt = currentPrompt;
        this.initialPrompt = initialPrompt;
        this.silent = silent;
        this.disableGlobalEvents = disableGlobalEvents;
    }

    public static ConversationBuilder builder(TelegramBot bot) {
        return new ConversationBuilder(bot);
    }

    public Conversation begin() {
        context.bot().getConversationRegistry().registerConversation(this);

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

        currentPrompt = currentPrompt.process(context, content);
        context.history().history.add(message);

        if (currentPrompt == null) {
            end();
        } else {
            SendableMessage promptMessage = currentPrompt.promptMessage(context);

            if (!silent && promptMessage != null) {
                forWhom.sendMessage(promptMessage);
            }
        }
    }

    public void end() {
        if (currentPrompt != null) {
            currentPrompt.conversationEnded(context);
            currentPrompt = null;
        }

        context.bot().getConversationRegistry().removeConversation(this);
    }

    public ConversationPrompt initialPrompt() {
        return initialPrompt;
    }

    public ConversationPrompt currentPrompt() {
        return currentPrompt;
    }

    public boolean silent() {
        return silent;
    }

    public Chat forWhom() {
        return forWhom;
    }

    public ConversationContext context() {
        return context;
    }

    public boolean disableGlobalEvents() {
        return disableGlobalEvents;
    }

    public static class ConversationBuilder {
        private final TelegramBot bot;
        private Chat forWhom;
        private ConversationPrompt initialPrompt;
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

        public ConversationBuilder initialPrompt(ConversationPrompt prompt) {
            this.initialPrompt = prompt;
            return this;
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
            Utils.validateNotNull(bot, forWhom, initialPrompt);
            return new Conversation(bot, sessionData, forWhom, silent, disableGlobalEvents,
                    initialPrompt, initialPrompt);
        }
    }
}
