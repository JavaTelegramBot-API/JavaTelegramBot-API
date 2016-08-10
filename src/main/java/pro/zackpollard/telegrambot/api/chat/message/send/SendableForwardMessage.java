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

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendableForwardMessageBuilder object used to construct the SendableForwardMessage object
     */
    public static SendableForwardMessageBuilder builder() {
        return new SendableForwardMessageBuilder();
    }

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
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

        /**
         * *Required unless using {@link #messageID(Long)} and {@link #chatID(String)}*
         * Sets the Message object that relates to the message you want to forward
         *
         * @param forwardedMessage The Message object relating to the message you want to forward
         *
         * @return The builder object
         */
        public SendableForwardMessage.SendableForwardMessageBuilder forwardedMessage(Message forwardedMessage) {
            this.messageID = forwardedMessage != null ? forwardedMessage.getMessageId() : null;
            this.chatID = forwardedMessage != null ? forwardedMessage.getChat().getId() : null;
            return this;
        }

        /**
         * *Required unless using {@link #forwardedMessage(Message)}*
         * Sets the ID of the message you want to forward
         *
         * @param messageID The ID of the message you want to forward
         *
         * @return The builder object
         */
        public SendableForwardMessage.SendableForwardMessageBuilder messageID(Long messageID) {
            this.messageID = messageID;
            return this;
        }

        /**
         * *Required unless using {@link #forwardedMessage(Message)}*
         * Sets the ID of the chat that contains the message you want to forward
         *
         * @param chatID The ID of the chat containing the message you want to forward
         *
         * @return The builder object
         */
        public SendableForwardMessage.SendableForwardMessageBuilder chatID(String chatID) {
            this.chatID = chatID;
            return this;
        }

        /**
         * Sets whether or not to disable any notification this message might usually cause. Defaults to False
         *
         * @param disableNotification True to disable notifications for this message, False otherwise
         *
         * @return The builder object
         */
        public SendableForwardMessage.SendableForwardMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        /**
         * Builds the SendableForwardMessage object
         *
         * @return A SendableForwardMessage object based on the previously provided values
         */
        public SendableForwardMessage build() {
            return new SendableForwardMessage(messageID, chatID, disableNotification);
        }
    }
}