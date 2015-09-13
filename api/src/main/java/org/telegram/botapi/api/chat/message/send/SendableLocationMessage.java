package org.telegram.botapi.api.chat.message.send;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */

@RequiredArgsConstructor
@Builder
public class SendableLocationMessage implements SendableMessage, ReplyingOptions {

	@Getter
    private final float latitude;
	@Getter
	private final float longitude;
	@Getter
	private final Message replyTo;
	@Getter
	private final ReplyMarkup replyMarkup;

    @Override
    public MessageType getType() {
        return MessageType.LOCATION;
    }
}