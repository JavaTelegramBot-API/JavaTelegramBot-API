package pro.zackpollard.telegrambot.api.internal.conversations;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.conversations.Conversation;
import pro.zackpollard.telegrambot.api.conversations.ConversationRegistry;

import java.util.HashMap;
import java.util.Map;

public class ConversationRegistryImpl implements ConversationRegistry {
    private final Map<String, Conversation> activeConversations = new HashMap<>();

    private ConversationRegistryImpl() {
    }

    public static ConversationRegistry create() {
        return new ConversationRegistryImpl();
    }

    @Override
    public void registerConversation(Conversation conversation) {
        activeConversations.put(conversation.forWhom().getId(), conversation);
    }

    @Override
    public void removeConversation(Conversation conversation) {
        activeConversations.remove(conversation.forWhom().getId());

        if (conversation.currentPrompt() != null) {
            conversation.end();
        }
    }

    @Override
    public boolean processMessage(Message message) {
        Conversation conversation = activeConversations.get(message.getChat().getId());

        if (conversation == null) {
            return false;
        }

        if (conversation.currentPrompt().type() != message.getContent().getType()) {
            return conversation.disableGlobalEvents();
        }

        conversation.accept(message);
        return true;
    }
}
