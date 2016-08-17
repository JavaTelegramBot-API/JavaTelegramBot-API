package pro.zackpollard.telegrambot.api.event.chat;

import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.MigrateFromChatIDContent;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageEvent;

/**
 * @author Zack Pollard
 */
public class MigrateFromChatEvent extends MessageEvent {

    public MigrateFromChatEvent(Message message) {
        super(message);
    }

    /**
     * Gets the Chat that was migrated from that triggered this Event
     *
     * @return The Chat that was migrated from that triggered this Event
     */
    public Chat fromChat() {

        return getMessage().getBotInstance().getChat(((MigrateFromChatIDContent) getMessage().getContent()).getContent());
    }
}
