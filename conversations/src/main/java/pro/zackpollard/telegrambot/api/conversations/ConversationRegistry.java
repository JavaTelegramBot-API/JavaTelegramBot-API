package pro.zackpollard.telegrambot.api.conversations;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.conversations.internal.ConversationRegistryImpl;
import pro.zackpollard.telegrambot.api.extensions.Extension;

/**
 * A registry which holds conversations and manages the messages accordingly.
 *
 * @author Mazen Kotb
 * @see ConversationRegistryImpl
 */
@Extension.DefaultProvider(ConversationRegistryImpl.Provider.class)
public interface ConversationRegistry extends Extension {

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
}