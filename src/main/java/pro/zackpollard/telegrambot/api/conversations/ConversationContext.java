package pro.zackpollard.telegrambot.api.conversations;

import lombok.Getter;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.Chat;

import java.util.Map;

public final class ConversationContext {
    @Getter
    private final ConversationHistory history = ConversationHistory.create();
    @Getter
    private final Conversation conversation;
    @Getter
    private final Chat from;
    @Getter
    private final TelegramBot bot;
    private final Map<String, Object> conversationData;

    ConversationContext(Conversation conversation, TelegramBot bot, Map<String, Object> conversationData) {
        this.conversation = conversation;
        this.from = conversation.getForWhom();
        this.bot = bot;
        this.conversationData = conversationData;
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
