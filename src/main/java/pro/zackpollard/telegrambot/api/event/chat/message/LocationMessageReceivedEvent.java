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

    @Override
    public LocationContent getContent() {

        return (LocationContent) getMessage().getContent();
    }
}