package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.Content;

/**
 * @author Zack Pollard
 */

public class MessageReceivedEvent extends MessageEvent {

    public MessageReceivedEvent(Message message) {

        super(message);
    }

    /**
     * Gets the content that was received that triggered this Event
     *
     * @return The content that was received that triggered this Event
     */
    public Content getContent() {

        return getMessage().getContent();
    }
}
