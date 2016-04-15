package pro.zackpollard.telegrambot.api.event.chat;

import pro.zackpollard.telegrambot.api.chat.SuperGroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageEvent;

/**
 * @author Zack Pollard
 */
public class MigrateToChatEvent extends MessageEvent {

    public MigrateToChatEvent(Message message) {
        super(message);
    }

    @Override
    public SuperGroupChat getChat() {

        return (SuperGroupChat) getMessage().getChat();
    }
}
