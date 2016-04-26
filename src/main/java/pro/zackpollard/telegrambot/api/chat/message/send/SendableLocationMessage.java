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

    public static SendableLocationMessageBuilder builder() {
        return new SendableLocationMessageBuilder();
    }

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

        public SendableLocationMessage.SendableLocationMessageBuilder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public SendableLocationMessage.SendableLocationMessageBuilder longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public SendableLocationMessage.SendableLocationMessageBuilder replyTo(Message replyTo) {
            this.replyTo = replyTo != null ? replyTo.getMessageId() : 0;
            return this;
        }

        public SendableLocationMessage.SendableLocationMessageBuilder replyTo(long replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableLocationMessage.SendableLocationMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableLocationMessage.SendableLocationMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        public SendableLocationMessage build() {
            return new SendableLocationMessage(latitude, longitude, replyTo, replyMarkup, disableNotification);
        }
    }
}