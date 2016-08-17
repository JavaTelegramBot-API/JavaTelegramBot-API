package pro.zackpollard.telegrambot.api.conversations;

import pro.zackpollard.telegrambot.api.chat.message.Message;

/**
 * A registry which holds conversations and manages the messages accordingly.
 *
 * @author Mazen Kotb
 * @see pro.zackpollard.telegrambot.api.internal.conversations.ConversationRegistryImpl
 */
public interface ConversationRegistry {
    /**
     * Registers a conversation to be called
     * @param conversation conversation to be registered
     */
    void registerConversation(Conversation conversation);

    /**
     * Removes a conversation from the registry, declared ending.
     * If conversation has not ended, calls end() method.
     *
     * @param conversation conversation to be registered.
     * @see Conversation#end()
     */
    void removeConversation(Conversation conversation);

    /**
     * Processes a message received through the API
     * @param message message to be processed
     * @return Whether to cancel the event or not.
     */
    boolean processMessage(Message message);
}