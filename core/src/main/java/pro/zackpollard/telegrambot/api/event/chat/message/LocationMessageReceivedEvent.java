package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.LocationContent;

/**
 * @author Zack Pollard
 */
public class LocationMessageReceivedEvent extends MessageReceivedEvent {

    public LocationMessageReceivedEvent(Message message) {

        super(message);
    }

    /**
     * Gets the Location that was received that fired this Event
     *
     * @return The location that was received that fired this Event
     */
    @Override
    public LocationContent getContent() {

        return (LocationContent) getMessage().getContent();
    }
}