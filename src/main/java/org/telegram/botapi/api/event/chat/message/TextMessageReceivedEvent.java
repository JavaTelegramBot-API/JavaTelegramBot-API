package org.telegram.botapi.api.event.chat.message;

import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.content.TextContent;

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