package org.telegram.botapi.api.chat.message.send;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */

@RequiredArgsConstructor
@Builder
public class SendableAudioMessage implements SendableMessage, ReplyingOptions {

	@NonNull
	@Getter
	private final InputFile audio;
	@Getter
	private final int duration;
	@Getter
	private final String performer;
	@Getter
	private final String title;
	@Getter
	private final Message replyTo;
	@Getter
	private final ReplyMarkup replyMarkup;

	@Override
	public MessageType getType() {
		return MessageType.AUDIO;
	}
}