package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.VideoContent;
import pro.zackpollard.telegrambot.api.chat.message.content.VideoNoteContent;

/**
 * @author Zack Pollard
 */
public class VideoNoteMessageReceivedEvent extends MessageReceivedEvent {

    public VideoNoteMessageReceivedEvent(Message message) {

        super(message);
    }

    /**
     * Gets the Video that was received that triggered this Event
     *
     * @return The Video that was received that triggered this Event
     */
    @Override
    public VideoNoteContent getContent() {

        return (VideoNoteContent) getMessage().getContent();
    }
}