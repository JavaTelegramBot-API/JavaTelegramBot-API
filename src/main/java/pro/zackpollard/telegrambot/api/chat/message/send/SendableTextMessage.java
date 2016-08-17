package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendableTextMessage implements SendableMessage, ReplyingOptions, NotificationOptions {

    @NonNull
    @Getter
    private final String message;
    @Getter
    private final long replyTo;
    @Getter
    private final boolean disableWebPagePreview;
    @Getter
    private final ReplyMarkup replyMarkup;
    @Getter
    private final ParseMode parseMode;
    @Getter
    private final boolean disableNotification;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendableTextMessageBuilder object used to construct the SendableTextMessage object
     */
    public static SendableTextMessageBuilder builder() {
        return new SendableTextMessageBuilder();
    }

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
    @Override
    public MessageType getType() {
        return MessageType.TEXT;
    }

    @ToString
    public static class SendableTextMessageBuilder {

        private String message;
        private long replyTo;
        private boolean disableWebPagePreview;
        private ReplyMarkup replyMarkup;
        private ParseMode parseMode;
        private boolean disableNotification;

        SendableTextMessageBuilder() {
        }

        /**
         * *Required*
         * Sets the text to be sent
         *
         * @param message The text to be sent
         *
         * @return The builder object
         */
        public SendableTextMessage.SendableTextMessageBuilder message(String message) {
            this.message = message;
            return this;
        }

        /**
         * *Optional*
         * Sets the Message object that you want to reply to
         *
         * @param replyTo The Message object you want to reply to
         *
         * @return The builder object
         */
        public SendableTextMessage.SendableTextMessageBuilder replyTo(Message replyTo) {
            this.replyTo = replyTo != null ? replyTo.getMessageId() : 0;
            return this;
        }

        /**
         * *Optional*
         * Sets the ID of the message you want to reply to
         *
         * @param replyTo The ID of the message you want to reply to
         *
         * @return The builder object
         */
        public SendableTextMessage.SendableTextMessageBuilder replyTo(long replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableTextMessage.SendableTextMessageBuilder disableWebPagePreview(boolean disableWebPagePreview) {
            this.disableWebPagePreview = disableWebPagePreview;
            return this;
        }

        /**
         * *Optional*
         * Sets the ReplyMarkup that you want to send with the message
         *
         * @param replyMarkup The ReplyMarkup you want to send with the message
         *
         * @return The builder object
         */
        public SendableTextMessage.SendableTextMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        /**
         * *Optional*
         * Sets the ParseMode that you want to use for this message
         *
         * @param parseMode The ParseMode you want to use with this message
         *
         * @return The builder object
         */
        public SendableTextMessage.SendableTextMessageBuilder parseMode(ParseMode parseMode) {
            this.parseMode = parseMode;
            return this;
        }

        /**
         * *Optional*
         * Sets whether or not to disable any notification this message might usually cause. Defaults to False
         *
         * @param disableNotification True to disable notifications for this message, False otherwise
         *
         * @return The builder object
         */
        public SendableTextMessage.SendableTextMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        /**
         * Builds the SendableTextMessage object
         *
         * @return A SendableTextMessage object based on the previously provided values
         */
        public SendableTextMessage build() {
            return new SendableTextMessage(message, replyTo, disableWebPagePreview, replyMarkup, parseMode, disableNotification);
        }
    }
}