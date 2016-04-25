package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendableAudioMessage implements SendableMessage, ReplyingOptions, NotificationOptions {

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
    private final long replyTo;
    @Getter
    private final ReplyMarkup replyMarkup;
    @Getter
    private final boolean disableNotification;

    public static SendableAudioMessageBuilder builder() {
        return new SendableAudioMessageBuilder();
    }

    @Override
    public MessageType getType() {
        return MessageType.AUDIO;
    }

    @ToString
    public static class SendableAudioMessageBuilder {

        private InputFile audio;
        private int duration;
        private String performer;
        private String title;
        private long replyTo;
        private ReplyMarkup replyMarkup;
        private boolean disableNotification;

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

        public SendableAudioMessage.SendableAudioMessageBuilder replyTo(long replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableAudioMessage.SendableAudioMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableAudioMessage.SendableAudioMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        public SendableAudioMessage build() {
            return new SendableAudioMessage(audio, duration, performer, title, replyTo, replyMarkup, disableNotification);
        }
    }
}