package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */

public class SendableVideoMessage implements SendableMessage, ReplyingOptions {

	@NonNull
	@Getter
	private final InputFile video;
	@Getter
	private final int duration;
	@Getter
	private final String caption;
	@Getter
	private final int replyTo;
	@Getter
	private final ReplyMarkup replyMarkup;

    SendableVideoMessage(InputFile video, int duration, String caption, int replyTo, ReplyMarkup replyMarkup) {

        this.video = video;
        this.duration = duration;
        this.caption = caption;
        this.replyTo = replyTo;
        this.replyMarkup = replyMarkup;
    }

    SendableVideoMessage(InputFile video, int duration, String caption, Message replyTo, ReplyMarkup replyMarkup) {

        this(video, duration, caption, replyTo != null ? replyTo.getMessageId() : 0, replyMarkup);
    }

    public static SendableVideoMessageBuilder builder() {
        return new SendableVideoMessageBuilder();
    }

    @Override
	public MessageType getType() {
		return MessageType.VIDEO;
	}

    public static class SendableVideoMessageBuilder {

        private InputFile video;
        private int duration;
        private String caption;
        private int replyTo;
        private ReplyMarkup replyMarkup;

        SendableVideoMessageBuilder() {
        }

        public SendableVideoMessage.SendableVideoMessageBuilder video(InputFile video) {
            this.video = video;
            return this;
        }

        public SendableVideoMessage.SendableVideoMessageBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public SendableVideoMessage.SendableVideoMessageBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public SendableVideoMessage.SendableVideoMessageBuilder replyTo(Message replyTo) {
            this.replyTo = replyTo != null ? replyTo.getMessageId() : 0;
            return this;
        }

        public SendableVideoMessage.SendableVideoMessageBuilder replyTo(int replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableVideoMessage.SendableVideoMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableVideoMessage build() {
            return new SendableVideoMessage(video, duration, caption, replyTo, replyMarkup);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableVideoMessage.SendableVideoMessageBuilder(video=" + this.video + ", duration=" + this.duration + ", caption=" + this.caption + ", replyTo=" + this.replyTo + ", replyMarkup=" + this.replyMarkup + ")";
        }
    }
}