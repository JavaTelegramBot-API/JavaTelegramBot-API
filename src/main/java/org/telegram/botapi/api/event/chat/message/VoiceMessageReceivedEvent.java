package org.telegram.botapi.api.event.chat.message;

import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.content.VoiceContent;

/**
 * @author Zack Pollard
 */
public class VoiceMessageReceivedEvent extends MessageReceivedEvent {

	public VoiceMessageReceivedEvent(Message message) {

		super(message);
	}

	@Override
	public VoiceContent getContent() {

		return (VoiceContent) getMessage().getContent();
	}
}