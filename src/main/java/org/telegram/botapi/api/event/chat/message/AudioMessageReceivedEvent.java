package org.telegram.botapi.api.event.chat.message;

import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.content.AudioContent;

/**
 * @author Zack Pollard
 */
public class AudioMessageReceivedEvent extends MessageReceivedEvent {

	public AudioMessageReceivedEvent(Message message) {

		super(message);
	}

	@Override
	public AudioContent getContent() {

		return (AudioContent) getMessage().getContent();
	}
}