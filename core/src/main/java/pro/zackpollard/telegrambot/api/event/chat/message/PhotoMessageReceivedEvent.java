package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.PhotoContent;

/**
 * @author Zack Pollard
 */
public class PhotoMessageReceivedEvent extends MessageReceivedEvent {

    public PhotoMessageReceivedEvent(Message message) {

        super(message);
    }

    /**
     * Gets the Photo that was received that triggered this Event
     *
     * @return The Photo that was received that triggered this Event
     */
    @Override
    public PhotoContent getContent() {

        return (PhotoContent) getMessage().getContent();
    }
}