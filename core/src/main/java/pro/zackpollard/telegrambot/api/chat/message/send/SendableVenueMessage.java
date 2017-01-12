package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendableVenueMessage implements SendableMessage, ReplyingOptions, NotificationOptions {

    @Getter
    @NonNull
    private final double latitude;
    @Getter
    @NonNull
    private final double longitude;
    @Getter
    @NonNull
    private final String title;
    @Getter
    @NonNull
    private final String address;
    @Getter
    private final String foursquareId;
    @Getter
    private final long replyTo;
    @Getter
    private final ReplyMarkup replyMarkup;
    @Getter
    private final boolean disableNotification;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendableVenueMessageBuilder object used to construct the SendableVenueMessage object
     */
    public static SendableVenueMessageBuilder builder() {
        return new SendableVenueMessageBuilder();
    }

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
    @Override
    public MessageType getType() {
        return MessageType.VENUE;
    }

    @ToString
    public static class SendableVenueMessageBuilder {
        private double latitude;
        private double longitude;
        private String title;
        private String address;
        private String foursquareId;
        private long replyTo;
        private ReplyMarkup replyMarkup;
        private boolean disableNotification;

        SendableVenueMessageBuilder() {
        }

        /**
         * *Required*
         * Sets the latitude of the venue you want to send
         *
         * @param latitude The latitude of the venue
         *
         * @return The builder object
         */
        public SendableVenueMessage.SendableVenueMessageBuilder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * *Required*
         * Sets the longitude of the venue you want to send
         *
         * @param longitude The longitude of the venue
         *
         * @return The builder object
         */
        public SendableVenueMessage.SendableVenueMessageBuilder longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * *Required*
         * Sets the title of the venue to be sent
         *
         * @param title The title of the venue
         *
         * @return The builder object
         */
        public SendableVenueMessage.SendableVenueMessageBuilder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * *Required*
         * Sets the address of the venue to be sent
         *
         * @param address The address of the venue
         *
         * @return The builder object
         */
        public SendableVenueMessage.SendableVenueMessageBuilder address(String address) {
            this.address = address;
            return this;
        }

        /**
         * *Optional*
         * Sets the foursquare ID for the venue to be sent
         *
         * @param foursquareId The foursquare ID for the venue
         *
         * @return The builder object
         */
        public SendableVenueMessage.SendableVenueMessageBuilder foursquareId(String foursquareId) {
            this.foursquareId = foursquareId;
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
        public SendableVenueMessage.SendableVenueMessageBuilder replyTo(Message replyTo) {
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
        public SendableVenueMessage.SendableVenueMessageBuilder replyTo(long replyTo) {
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
        public SendableVenueMessage.SendableVenueMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
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
        public SendableVenueMessage.SendableVenueMessageBuilder disableNotification(boolean disableNotification) {
            this.disableNotification = disableNotification;
            return this;
        }

        /**
         * Builds the SendableVenueMessage object
         *
         * @return A SendableVenueMessage object based on the previously provided values
         */
        public SendableVenueMessage build() {
            return new SendableVenueMessage(latitude, longitude, title, address, foursquareId, replyTo, replyMarkup, disableNotification);
        }
    }
}