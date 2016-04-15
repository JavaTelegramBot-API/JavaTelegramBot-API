package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;

/**
 * @author Zack Pollard
 */

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
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