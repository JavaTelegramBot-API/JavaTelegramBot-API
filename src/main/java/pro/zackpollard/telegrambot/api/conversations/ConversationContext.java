package pro.zackpollard.telegrambot.api.conversations;

import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.Chat;

import java.util.Map;

public final class ConversationContext {
    private final ConversationHistory history = ConversationHistory.create();
    private final Conversation conversation;
    private final Chat from;
    private final TelegramBot bot;
    private final Map<String, Object> conversationData;

    ConversationContext(Conversation conversation, TelegramBot bot, Map<String, Object> conversationData) {
        this.conversation = conversation;
        this.from = conversation.forWhom();
        this.bot = bot;
        this.conversationData = conversationData;
    }

    public Chat from() {
        return from;
    }

    public Conversation conversation() {
        return conversation;
    }

    public ConversationHistory history() {
        return history;
    }

    public TelegramBot bot() {
        return bot;
    }

    public Object sessionDataBy(String key) {
        return conversationData.get(key);
    }

    public void setSessionData(String key, Object value) {
        conversationData.put(key, value);
    }

    public boolean hasDataBy(String key) {
        return conversationData.containsKey(key);
    }
}
