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
public class SendableForwardMessage implements SendableMessage {

    @NonNull
	@Getter
	private final Message forwardedMessage;

    @Override
    public MessageType getType() {
        return MessageType.FORWARDED;
    }
}