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
public class SendableDocumentMessage implements SendableMessage {

    @NonNull
    private final InputFile document;
    private final Message replyTo;
    private final ReplyMarkup replyMarkup;

    @Override
    public MessageType getType() {
        return MessageType.DOCUMENT;
    }
}