package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendableLocationMessage implements SendableMessage, ReplyingOptions, NotificationOptions {

    @Getter
    @NonNull
    private final double latitude;
    @Getter
    @NonNull
    private final double longitude;
    @Getter
    private final long replyTo;
    @Getter
    private final ReplyMarkup replyMarkup;
    @Getter
    private final boolean disableNotification;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendableLocationMessageBuilder object used to construct the SendableLocationMessage object
     */
    public static SendableLocationMessageBuilder builder() {
        return new SendableLocationMessageBuilder();
    }

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
    @Override
    public MessageType getType() {
        return MessageType.LOCATION;
    }

    @ToString
    public static class SendableLocationMessageBuilder {

        private double latitude;
        private double longitude;
        private long replyTo;
        private ReplyMarkup replyMarkup;
        private boolean disableNotification;

        SendableLocationMessageBuilder() {
        }

        /**
         * *Required*
         * Sets the latitude of the location you want to send
         *
         * @param latitude The latitude of the location
         *
         * @return The builder object
         */
        public SendableLocationMessage.SendableLocationMessageBuilder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * *Required*
         * Sets the longitude of the location you want to send
         *
         * @param longitude The longitude of the location
         *
         * @return The builder object
         */
        public SendableLocationMessage.SendableLocationMessageBuilder longitude(double longitude) {
            this.longitude = longitude;
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
        public SendableLocationMessage.SendableLocationMessageBuilder replyTo(Message replyTo) {
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
        public SendableLocationMessage.SendableLocationMessageBuilder replyTo(long replyTo) {
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
        public SendableLocationMessage.SendableLocationMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
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
        public SendableLocationMessage.SendableLocationMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        /**
         * Builds the SendableLocationMessage object
         *
         * @return A SendableLocationMessage object based on the previously provided values
         */
        public SendableLocationMessage build() {
            return new SendableLocationMessage(latitude, longitude, replyTo, replyMarkup, disableNotification);
        }
    }
}