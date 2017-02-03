package pro.zackpollard.telegrambot.api.conversations.internal;

import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.conversations.Conversation;
import pro.zackpollard.telegrambot.api.conversations.ConversationRegistry;
import pro.zackpollard.telegrambot.api.event.Event;
import pro.zackpollard.telegrambot.api.event.Listener;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageReceivedEvent;
import pro.zackpollard.telegrambot.api.extensions.Extension;

import java.util.HashMap;
import java.util.Map;

public class ConversationRegistryImpl implements ConversationRegistry {
    public static class Provider implements Extension.Provider<ConversationRegistry> {
        @Override
        public ConversationRegistry create(TelegramBot bot) {
            return new ConversationRegistryImpl(bot);
        }
    }

    private final Map<String, Conversation> activeConversations = new HashMap<>();

    private ConversationRegistryImpl(TelegramBot bot) {
        bot.getEventsManager().register(new Listener() {
            @Override
            @Event.Handler(ignoreCancelled = true, priority = Event.Priority.LOWEST)
            public void onMessageReceived(MessageReceivedEvent event) {
                if (processMessage(event.getMessage())) {
                    event.setCancelled(true);
                }
            }
        });
    }

    @Override
    public void registerConversation(Conversation conversation) {
        activeConversations.put(conversation.getForWhom().getId(), conversation);
    }

    @Override
    public void removeConversation(Conversation conversation) {
        activeConversations.remove(conversation.getForWhom().getId());

        if (conversation.getCurrentPrompt() != null) {
            conversation.end();
        }
    }

    private boolean processMessage(Message message) {
        Conversation conversation = activeConversations.get(message.getChat().getId());

        if (conversation == null) {
            return false;
        }

        if (conversation.getCurrentPrompt().type() != message.getContent().getType()) {
            return conversation.isDisableGlobalEvents();
        }

        conversation.accept(message);
        return true;
    }
}
