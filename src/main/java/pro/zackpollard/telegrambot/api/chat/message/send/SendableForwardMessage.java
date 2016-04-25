package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.message.Message;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendableForwardMessage implements SendableMessage, NotificationOptions {

    @NonNull
    @Getter
    private final Long messageID;
    @NonNull
    @Getter
    private final String chatID;
    @Getter
    private final boolean disableNotification;

    public static SendableForwardMessageBuilder builder() {
        return new SendableForwardMessageBuilder();
    }

    @Override
    public MessageType getType() {
        return MessageType.FORWARDED;
    }

    @ToString
    public static class SendableForwardMessageBuilder {

        private Long messageID;
        private String chatID;
        private boolean disableNotification;

        SendableForwardMessageBuilder() {
        }

        public SendableForwardMessage.SendableForwardMessageBuilder forwardedMessage(Message forwardedMessage) {
            this.messageID = forwardedMessage != null ? forwardedMessage.getMessageId() : null;
            this.chatID = forwardedMessage != null ? forwardedMessage.getChat().getId() : null;
            return this;
        }

        public SendableForwardMessage.SendableForwardMessageBuilder messageID(Long messageID) {
            this.messageID = messageID;
            return this;
        }

        public SendableForwardMessage.SendableForwardMessageBuilder chatID(String chatID) {
            this.chatID = chatID;
            return this;
        }

        public SendableForwardMessage.SendableForwardMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        public SendableForwardMessage build() {
            return new SendableForwardMessage(messageID, chatID, disableNotification);
        }
    }
}