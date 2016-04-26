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

    @Override
    public TextContent getContent() {

        return (TextContent) getMessage().getContent();
    }
}