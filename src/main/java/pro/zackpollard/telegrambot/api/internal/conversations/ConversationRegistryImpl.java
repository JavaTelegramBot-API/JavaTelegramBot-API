package pro.zackpollard.telegrambot.api.internal.conversations;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.conversations.Conversation;
import pro.zackpollard.telegrambot.api.conversations.ConversationRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversationRegistryImpl implements ConversationRegistry {
    private final Map<String, List<Conversation>> activeConversations = new HashMap<>();

    private ConversationRegistryImpl() {
    }

    public static ConversationRegistry create() {
        return new ConversationRegistryImpl();
    }

    @Override
    public void registerConversation(Conversation conversation) {
        String id = conversation.getForWhom().getId();

        if (!activeConversations.containsKey(id)) {
            activeConversations.put(id, new ArrayList<>());
        }

        activeConversations.get(id).add(conversation);
    }

    @Override
    public void removeConversation(Conversation conversation) {
        String id = conversation.getForWhom().getId();

        if (activeConversations.containsKey(id)) {
            activeConversations.get(id).remove(conversation);
        }

        if (conversation.getCurrentPrompt() != null) {
            conversation.end();
        }
    }

    @Override
    public boolean processMessage(Message message) {
        List<Conversation> conversations = activeConversations.get(message.getChat().getId());

        if (conversations == null) {
            return false;
        }

        boolean disableEvents = false;

        for (Conversation conversation : conversations) {
            if (conversation.getCurrentPrompt().type() != message.getContent().getType() && !disableEvents) {
                disableEvents = conversation.isDisableGlobalEvents();
            }

            if (conversation.accept(message)) {
                return true;
            }
        }

        return false;
    }
}
