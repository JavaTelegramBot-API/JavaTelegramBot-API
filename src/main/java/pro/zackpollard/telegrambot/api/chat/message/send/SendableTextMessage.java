package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */

@RequiredArgsConstructor
@Builder
public class SendableTextMessage implements SendableMessage, ReplyingOptions {

	@NonNull
	@Getter
	private final String message;
	@Getter
	private final Message replyTo;
	@Getter
	private final boolean disableWebPagePreview;
	@Getter
	private final ReplyMarkup replyMarkup;

	@Override
	public MessageType getType() {
		return MessageType.TEXT;
	}
}