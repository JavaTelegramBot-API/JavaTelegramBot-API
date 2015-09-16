package org.telegram.botapi.api.event.chat.message;

import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.content.StickerContent;

/**
 * @author Zack Pollard
 */
public class StickerMessageReceivedEvent extends MessageReceivedEvent {

	public StickerMessageReceivedEvent(Message message) {

		super(message);
	}

	@Override
	public StickerContent getContent() {

		return (StickerContent) getMessage().getContent();
	}
}