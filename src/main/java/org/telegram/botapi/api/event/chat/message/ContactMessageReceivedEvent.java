package org.telegram.botapi.api.event.chat.message;

import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.content.ContactContent;

/**
 * @author Zack Pollard
 */
public class ContactMessageReceivedEvent extends MessageReceivedEvent {

	public ContactMessageReceivedEvent(Message message) {

		super(message);
	}

	@Override
	public ContactContent getContent() {

		return (ContactContent) getMessage().getContent();
	}
}