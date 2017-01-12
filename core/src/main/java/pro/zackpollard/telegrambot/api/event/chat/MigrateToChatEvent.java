package pro.zackpollard.telegrambot.api.event.chat;

import pro.zackpollard.telegrambot.api.chat.SuperGroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.MigrateToChatIDContent;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageEvent;

/**
 * @author Zack Pollard
 */
public class MigrateToChatEvent extends MessageEvent {

    public MigrateToChatEvent(Message message) {
        super(message);
    }

    /**
     * Gets the Chat that was migrated to that triggered this Event
     *
     * @return The Chat that was migrated to that triggred this Event
     */
    @Override
    public SuperGroupChat getChat() {

        return (SuperGroupChat) getMessage().getBotInstance().getChat(((MigrateToChatIDContent) getMessage().getContent()).getContent());
    }
}
