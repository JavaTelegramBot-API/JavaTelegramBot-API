package org.telegram.botapi.api.chat.message.send;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.ReplyMarkup;
import org.telegram.botapi.api.chat.message.content.PhotoContent;

/**
 * @author Zack Pollard
 */

@RequiredArgsConstructor
@Builder
public class SendablePhotoMessage implements SendableMessage {

    @NonNull
    @Getter
	private final InputFile photo;
    @Getter
	private final String caption;
    @Getter
	private final Message replyTo;
    @Getter
	private final ReplyMarkup replyMarkup;

    @Override
    public MessageType getType() {
        return MessageType.PHOTO;
    }
}