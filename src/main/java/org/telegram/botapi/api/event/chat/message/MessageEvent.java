package org.telegram.botapi.api.event.chat.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.telegram.botapi.api.chat.Chat;
import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.event.Event;

/**
 * @author Zack Pollard
 */

@RequiredArgsConstructor
public abstract class MessageEvent implements Event {

	@Getter
	private final Message message;

	public Chat getChat() {

		return message.getChat();
	}
}
