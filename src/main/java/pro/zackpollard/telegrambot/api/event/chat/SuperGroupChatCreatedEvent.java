package pro.zackpollard.telegrambot.api.event.chat;

import pro.zackpollard.telegrambot.api.chat.SuperGroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageEvent;

/**
 * @author Zack Pollard
 */
public class SuperGroupChatCreatedEvent extends MessageEvent {

    public SuperGroupChatCreatedEvent(Message message) {
        super(message);
    }

    /**
     * Gets the SuperGroupChat that was created that triggered this Event
     *
     * @return The SuperGroupChat that was created that triggered this Event
     */
    @Override
    public SuperGroupChat getChat() {

        return (SuperGroupChat) getMessage().getChat();
    }
}
