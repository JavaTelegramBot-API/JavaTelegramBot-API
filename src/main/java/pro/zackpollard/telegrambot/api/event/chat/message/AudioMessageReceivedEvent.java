package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.AudioContent;

/**
 * @author Zack Pollard
 */
public class AudioMessageReceivedEvent extends MessageReceivedEvent {

    public AudioMessageReceivedEvent(Message message) {

        super(message);
    }

    /**
     * Gets the AudioContent that was received that fired this Event
     *
     * @return The AudioContent that was received that fired this Event
     */
    @Override
    public AudioContent getContent() {

        return (AudioContent) getMessage().getContent();
    }
}