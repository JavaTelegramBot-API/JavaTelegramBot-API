package pro.zackpollard.telegrambot.api.conversations;

import lombok.Getter;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.Chat;

import java.util.Map;

/**
 * Context data for a conversation; history, metadata, and telegram bot.
 * Used by prompts as a utility.
 *
 * @author Mazen Kotb
 */
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

    /**
     * Session data accessible by the key, null if not present
     * @param key The key of the session data
     * @return session data
     */
    public Object sessionDataBy(String key) {
        return conversationData.get(key);
    }

    /**
     * Add session data
     * @param key the key of the data
     * @param value the value of the data
     */
    public void setSessionData(String key, Object value) {
        conversationData.put(key, value);
    }

    /**
     * @param key The key of the session data
     * @return whether there is data present by that key
     */
    public boolean hasDataBy(String key) {
        return conversationData.containsKey(key);
    }
}
