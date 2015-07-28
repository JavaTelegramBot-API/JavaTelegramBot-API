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
public class SendableChatAction implements SendableMessage {

    @NonNull
    private final ChatAction chatAction;

    @Override
    public MessageType getType() {
        return MessageType.CHAT_ACTION;
    }
}