package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.VideoContent;

/**
 * @author Zack Pollard
 */
public class VideoMessageReceivedEvent extends MessageReceivedEvent {

    public VideoMessageReceivedEvent(Message message) {

        super(message);
    }

    /**
     * Gets the Video that was received that triggered this Event
     *
     * @return The Video that was received that triggered this Event
     */
    @Override
    public VideoContent getContent() {

        return (VideoContent) getMessage().getContent();
    }
}