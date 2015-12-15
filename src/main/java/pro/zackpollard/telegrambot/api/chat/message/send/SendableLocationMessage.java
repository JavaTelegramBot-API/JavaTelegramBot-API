package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */

public class SendableLocationMessage implements SendableMessage, ReplyingOptions {

	@Getter
	@NonNull
	private final double latitude;
	@Getter
	@NonNull
	private final double longitude;
	@Getter
	private final int replyTo;
	@Getter
	private final ReplyMarkup replyMarkup;

    public SendableLocationMessage(double latitude, double longitude, int replyTo, ReplyMarkup replyMarkup) {

        this.latitude = latitude;
        this.longitude = longitude;
        this.replyTo = replyTo;
        this.replyMarkup = replyMarkup;
    }

    public SendableLocationMessage(double latitude, double longitude, Message replyTo, ReplyMarkup replyMarkup) {

        this(latitude, longitude, replyTo != null ? replyTo.getMessageId() : 0, replyMarkup);
    }

    public static SendableLocationMessageBuilder builder() {
        return new SendableLocationMessageBuilder();
    }

    @Override
	public MessageType getType() {
		return MessageType.LOCATION;
	}

    public static class SendableLocationMessageBuilder {

        private double latitude;
        private double longitude;
        private int replyTo;
        private ReplyMarkup replyMarkup;

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

        public SendableLocationMessage.SendableLocationMessageBuilder replyTo(int replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableLocationMessage.SendableLocationMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableLocationMessage build() {
            return new SendableLocationMessage(latitude, longitude, replyTo, replyMarkup);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableLocationMessage.SendableLocationMessageBuilder(latitude=" + this.latitude + ", longitude=" + this.longitude + ", replyTo=" + this.replyTo + ", replyMarkup=" + this.replyMarkup + ")";
        }
    }
}