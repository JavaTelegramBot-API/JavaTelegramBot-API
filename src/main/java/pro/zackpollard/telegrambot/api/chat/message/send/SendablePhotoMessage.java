package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendablePhotoMessage implements SendableMessage, ReplyingOptions, NotificationOptions {

    @NonNull
    @Getter
    private final InputFile photo;
    @Getter
    private final String caption;
    @Getter
    private final long replyTo;
    @Getter
    private final ReplyMarkup replyMarkup;
    @Getter
    private final boolean disableNotification;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendablePhotoMessageBuilder object used to construct the SendablePhotoMessage object
     */
    public static SendablePhotoMessageBuilder builder() {
        return new SendablePhotoMessageBuilder();
    }

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
    @Override
    public MessageType getType() {
        return MessageType.PHOTO;
    }

    @ToString
    public static class SendablePhotoMessageBuilder {

        private InputFile photo;
        private String caption;
        private long replyTo;
        private ReplyMarkup replyMarkup;
        private boolean disableNotification;

        SendablePhotoMessageBuilder() {
        }

        /**
         * *Required*
         * Sets the photo InputFile to be sent
         *
         * @param photo The photo InputFile
         *
         * @return The builder object
         */
        public SendablePhotoMessage.SendablePhotoMessageBuilder photo(InputFile photo) {
            this.photo = photo;
            return this;
        }

        /**
         * *Optional*
         * Sets the caption that you want to send with the Message
         *
         * @param caption The caption you want to send with the Message
         *
         * @return The builder object
         */
        public SendablePhotoMessage.SendablePhotoMessageBuilder caption(String caption) {
            this.caption = caption;
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
        public SendablePhotoMessage.SendablePhotoMessageBuilder replyTo(Message replyTo) {
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
        public SendablePhotoMessage.SendablePhotoMessageBuilder replyTo(long replyTo) {
            this.replyTo = replyTo;
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
        public SendablePhotoMessage.SendablePhotoMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
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
        public SendablePhotoMessage.SendablePhotoMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        /**
         * Builds the SendablePhotoMessage object
         *
         * @return A SendablePhotoMessage object based on the previously provided values
         */
        public SendablePhotoMessage build() {
            return new SendablePhotoMessage(photo, caption, replyTo, replyMarkup, disableNotification);
        }
    }
}