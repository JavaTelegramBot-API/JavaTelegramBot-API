package org.telegram.botapi.api.chat.message.send;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */

@RequiredArgsConstructor
@Builder
public class SendableTextMessage implements SendableMessage {

    @NonNull
    private final String message;
    private final Message replyTo;
    private final boolean disableWebPagePreview;
    private final ReplyMarkup replyMarkup;

    @Override
    public MessageType getType() {
        return MessageType.TEXT;
    }
}