package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.ContactContent;

/**
 * @author Zack Pollard
 */
public class ContactMessageReceivedEvent extends MessageReceivedEvent {

    public ContactMessageReceivedEvent(Message message) {

        super(message);
    }

    /**
     * Gets the Contact that was received that fired this event
     *
     * @return The Contanct that was received that fired this event
     */
    @Override
    public ContactContent getContent() {

        return (ContactContent) getMessage().getContent();
    }
}