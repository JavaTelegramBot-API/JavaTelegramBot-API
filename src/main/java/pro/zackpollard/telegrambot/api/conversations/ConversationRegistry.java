package pro.zackpollard.telegrambot.api.conversations;

import pro.zackpollard.telegrambot.api.chat.message.Message;

public interface ConversationRegistry {
    void registerConversation(Conversation conversation);
    void removeConversation(Conversation conversation);
    boolean processMessage(Message message);
}