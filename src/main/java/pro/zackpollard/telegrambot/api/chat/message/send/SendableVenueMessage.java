package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */

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

    public static SendableVenueMessageBuilder builder() {
        return new SendableVenueMessageBuilder();
    }

    @Override
    public MessageType getType() {
        return MessageType.VENUE;
    }

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

        public SendableVenueMessage.SendableVenueMessageBuilder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public SendableVenueMessage.SendableVenueMessageBuilder longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public SendableVenueMessage.SendableVenueMessageBuilder title(String title) {
            this.title = title;
            return this;
        }

        public SendableVenueMessage.SendableVenueMessageBuilder address(String address) {
            this.address = address;
            return this;
        }

        public SendableVenueMessage.SendableVenueMessageBuilder foursquareId(String foursquareId) {
            this.foursquareId = foursquareId;
            return this;
        }

        public SendableVenueMessage.SendableVenueMessageBuilder replyTo(Message replyTo) {
            this.replyTo = replyTo != null ? replyTo.getMessageId() : 0;
            return this;
        }

        public SendableVenueMessage.SendableVenueMessageBuilder replyTo(long replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableVenueMessage.SendableVenueMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableVenueMessage.SendableVenueMessageBuilder disableNotification(boolean disableNotification) {
            this.disableNotification = disableNotification;
            return this;
        }

        public SendableVenueMessage build() {
            return new SendableVenueMessage(latitude, longitude, title, address, foursquareId, replyTo, replyMarkup, disableNotification);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableVenueMessage.SendableVenueMessageBuilder(latitude=" + this.latitude + ", longitude=" + this.longitude + ", title=" + this.title + ", address=" + this.address + ", foursquareId=" + this.foursquareId + ", replyTo=" + this.replyTo + ", replyMarkup=" + this.replyMarkup + ", disableNotification=" + this.disableNotification + ")";
        }
    }
}