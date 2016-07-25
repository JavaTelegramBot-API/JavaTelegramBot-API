package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendableChatAction implements SendableMessage {

    @NonNull
    @Getter
    private final ChatAction chatAction;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendableChatActionBuilder object used to construct the SendableChatAction object
     */
    public static SendableChatActionBuilder builder() {
        return new SendableChatActionBuilder();
    }

    @Override
    public MessageType getType() {
        return MessageType.CHAT_ACTION;
    }

    public static class SendableChatActionBuilder {
        private ChatAction chatAction;

        SendableChatActionBuilder() {
        }

        public SendableChatAction.SendableChatActionBuilder chatAction(ChatAction chatAction) {
            this.chatAction = chatAction;
            return this;
        }

        public SendableChatAction build() {
            return new SendableChatAction(chatAction);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableChatAction.SendableChatActionBuilder(chatAction=" + this.chatAction + ")";
        }
    }
}