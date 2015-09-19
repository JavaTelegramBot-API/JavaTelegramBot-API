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
public class SendableLocationMessage implements SendableMessage, ReplyingOptions {

	@Getter
	@NonNull
	private final double latitude;
	@Getter
	@NonNull
	private final double longitude;
	@Getter
	private final Message replyTo;
	@Getter
	private final ReplyMarkup replyMarkup;

	@Override
	public MessageType getType() {
		return MessageType.LOCATION;
	}
}