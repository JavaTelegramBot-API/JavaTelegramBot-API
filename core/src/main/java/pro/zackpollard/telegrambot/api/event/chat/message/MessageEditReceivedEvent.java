package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.Content;

/**
 * @author Zack Pollard
 */
public class MessageEditReceivedEvent extends MessageEvent {

    public MessageEditReceivedEvent(Message message) {

        super(message);
    }

    /**
     * Gets the message edit that was received that fired this Event
     *
     * @return The message edit that was received that fired this Event
     */
    public Content getContent() {

        return getMessage().getContent();
    }
}
