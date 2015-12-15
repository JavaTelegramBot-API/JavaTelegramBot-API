package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */

public class SendableAudioMessage implements SendableMessage, ReplyingOptions {

	@NonNull
	@Getter
	private final InputFile audio;
	@Getter
	private final int duration;
	@Getter
	private final String performer;
	@Getter
	private final String title;
	@Getter
	private final int replyTo;
	@Getter
	private final ReplyMarkup replyMarkup;

    public SendableAudioMessage(InputFile audio, int duration, String performer, String title, int replyTo, ReplyMarkup replyMarkup) {

        this.audio = audio;
        this.duration = duration;
        this.performer = performer;
        this.title = title;
        this.replyTo = replyTo;
        this.replyMarkup = replyMarkup;
    }

    public SendableAudioMessage(InputFile audio, int duration, String performer, String title, Message replyTo, ReplyMarkup replyMarkup) {

        this(audio, duration, performer, title, replyTo != null ? replyTo.getMessageId() : 0, replyMarkup);
    }

    public static SendableAudioMessageBuilder builder() {
        return new SendableAudioMessageBuilder();
    }

    @Override
	public MessageType getType() {
		return MessageType.AUDIO;
	}

    public static class SendableAudioMessageBuilder {

        private InputFile audio;
        private int duration;
        private String performer;
        private String title;
        private int replyTo;
        private ReplyMarkup replyMarkup;

        SendableAudioMessageBuilder() {
        }

        public SendableAudioMessage.SendableAudioMessageBuilder audio(InputFile audio) {
            assert audio != null;
            this.audio = audio;
            return this;
        }

        public SendableAudioMessage.SendableAudioMessageBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public SendableAudioMessage.SendableAudioMessageBuilder performer(String performer) {
            this.performer = performer;
            return this;
        }

        public SendableAudioMessage.SendableAudioMessageBuilder title(String title) {
            this.title = title;
            return this;
        }

        public SendableAudioMessage.SendableAudioMessageBuilder replyTo(Message replyTo) {
            this.replyTo = replyTo != null ? replyTo.getMessageId() : 0;
            return this;
        }

        public SendableAudioMessage.SendableAudioMessageBuilder reployTo(int replyTo) {

            this.replyTo = replyTo;
            return this;
        }

        public SendableAudioMessage.SendableAudioMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableAudioMessage build() {
            return new SendableAudioMessage(audio, duration, performer, title, replyTo, replyMarkup);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableAudioMessage.SendableAudioMessageBuilder(audio=" + this.audio + ", duration=" + this.duration + ", performer=" + this.performer + ", title=" + this.title + ", replyTo=" + this.replyTo + ", replyMarkup=" + this.replyMarkup + ")";
        }
    }
}