package org.telegram.botapi.api.event.chat.message;

import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.content.VideoContent;

/**
 * @author Zack Pollard
 */
public class VideoMessageReceivedEvent extends MessageReceivedEvent {

	public VideoMessageReceivedEvent(Message message) {

		super(message);
	}

	@Override
	public VideoContent getContent() {

		return (VideoContent) getMessage().getContent();
	}
}