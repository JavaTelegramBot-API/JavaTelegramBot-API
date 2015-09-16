package org.telegram.botapi.api.event.chat.message;

import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.content.PhotoContent;

/**
 * @author Zack Pollard
 */
public class PhotoMessageReceivedEvent extends MessageReceivedEvent {

	public PhotoMessageReceivedEvent(Message message) {

		super(message);
	}

	@Override
	public PhotoContent getContent() {

		return (PhotoContent) getMessage().getContent();
	}
}