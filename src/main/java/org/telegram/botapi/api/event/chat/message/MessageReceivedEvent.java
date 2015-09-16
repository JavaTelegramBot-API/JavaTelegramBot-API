package org.telegram.botapi.api.event.chat.message;

import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.content.Content;

/**
 * @author Zack Pollard
 */

public abstract class MessageReceivedEvent extends MessageEvent {

	public MessageReceivedEvent(Message message) {

		super(message);
	}

	public Content getContent() {

		return getMessage().getContent();
	}
}
