package org.telegram.botapi.api.event.chat.message;

import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.content.DocumentContent;

/**
 * @author Zack Pollard
 */
public class DocumentMessageReceivedEvent extends MessageReceivedEvent {

	public DocumentMessageReceivedEvent(Message message) {

		super(message);
	}

	@Override
	public DocumentContent getContent() {

		return (DocumentContent) getMessage().getContent();
	}
}