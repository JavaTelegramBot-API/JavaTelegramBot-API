package org.telegram.botapi.api.chat.message.send;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Zack Pollard
 */

@RequiredArgsConstructor
@Builder
public class SendableChatAction implements SendableMessage {

	@NonNull
	@Getter
	private final ChatAction chatAction;

	@Override
	public MessageType getType() {
		return MessageType.CHAT_ACTION;
	}
}