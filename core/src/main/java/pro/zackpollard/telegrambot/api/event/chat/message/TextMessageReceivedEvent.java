package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;

/**
 * @author Zack Pollard
 */
public class TextMessageReceivedEvent extends MessageReceivedEvent {

    public TextMessageReceivedEvent(Message message) {

        super(message);
    }

    /**
     * Gets the Text that was received that triggered this Event
     *
     * @return The Text that was received that triggered this Event
     */
    @Override
    public TextContent getContent() {

        return (TextContent) getMessage().getContent();
    }
}