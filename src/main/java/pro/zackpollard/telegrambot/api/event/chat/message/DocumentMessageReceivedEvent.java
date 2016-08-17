package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.DocumentContent;

/**
 * @author Zack Pollard
 */
public class DocumentMessageReceivedEvent extends MessageReceivedEvent {

    public DocumentMessageReceivedEvent(Message message) {

        super(message);
    }

    /**
     * Gets the Document that was received that fired this Event
     *
     * @return The document that was received that fired this Event
     */
    @Override
    public DocumentContent getContent() {

        return (DocumentContent) getMessage().getContent();
    }
}