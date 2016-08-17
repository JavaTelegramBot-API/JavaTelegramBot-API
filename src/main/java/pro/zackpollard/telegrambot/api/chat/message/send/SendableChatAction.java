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

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
    @Override
    public MessageType getType() {
        return MessageType.CHAT_ACTION;
    }

    public static class SendableChatActionBuilder {
        private ChatAction chatAction;

        SendableChatActionBuilder() {
        }

        /**
         * *Required*
         * Sets the ChatAction that you want to send
         *
         * @param chatAction The ChatActio that you want to send
         *
         * @return The builder object
         */
        public SendableChatAction.SendableChatActionBuilder chatAction(ChatAction chatAction) {
            this.chatAction = chatAction;
            return this;
        }

        /**
         * Builds the SendableChatAction object
         *
         * @return A SendableChatAction object based on the previously provided values
         */
        public SendableChatAction build() {
            return new SendableChatAction(chatAction);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableChatAction.SendableChatActionBuilder(chatAction=" + this.chatAction + ")";
        }
    }
}