package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */

public class SendablePhotoMessage implements SendableMessage, ReplyingOptions {

	@NonNull
	@Getter
	private final InputFile photo;
	@Getter
	private final String caption;
	@Getter
	private final int replyTo;
	@Getter
	private final ReplyMarkup replyMarkup;

    public SendablePhotoMessage(InputFile photo, String caption, int replyTo, ReplyMarkup replyMarkup) {

        this.photo = photo;
        this.caption = caption;
        this.replyTo = replyTo;
        this.replyMarkup = replyMarkup;
    }

    public SendablePhotoMessage(InputFile photo, String caption, Message replyTo, ReplyMarkup replyMarkup) {

        this(photo, caption, replyTo != null ? replyTo.getMessageId() : 0, replyMarkup);
    }

    public static SendablePhotoMessageBuilder builder() {
        return new SendablePhotoMessageBuilder();
    }

    @Override
	public MessageType getType() {
		return MessageType.PHOTO;
	}

    public static class SendablePhotoMessageBuilder {

        private InputFile photo;
        private String caption;
        private int replyTo;
        private ReplyMarkup replyMarkup;

        SendablePhotoMessageBuilder() {
        }

        public SendablePhotoMessage.SendablePhotoMessageBuilder photo(InputFile photo) {
            this.photo = photo;
            return this;
        }

        public SendablePhotoMessage.SendablePhotoMessageBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public SendablePhotoMessage.SendablePhotoMessageBuilder replyTo(Message replyTo) {
            this.replyTo = replyTo != null ? replyTo.getMessageId() : 0;
            return this;
        }

        public SendablePhotoMessage.SendablePhotoMessageBuilder replyTo(int replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendablePhotoMessage.SendablePhotoMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendablePhotoMessage build() {
            return new SendablePhotoMessage(photo, caption, replyTo, replyMarkup);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendablePhotoMessage.SendablePhotoMessageBuilder(photo=" + this.photo + ", caption=" + this.caption + ", replyTo=" + this.replyTo + ", replyMarkup=" + this.replyMarkup + ")";
        }
    }
}