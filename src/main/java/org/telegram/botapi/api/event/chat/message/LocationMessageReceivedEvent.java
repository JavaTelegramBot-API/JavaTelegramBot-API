package org.telegram.botapi.api.event.chat.message;

import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.content.LocationContent;

/**
 * @author Zack Pollard
 */
public class LocationMessageReceivedEvent extends MessageReceivedEvent {

	public LocationMessageReceivedEvent(Message message) {

		super(message);
	}

	@Override
	public LocationContent getContent() {

		return (LocationContent) getMessage().getContent();
	}
}