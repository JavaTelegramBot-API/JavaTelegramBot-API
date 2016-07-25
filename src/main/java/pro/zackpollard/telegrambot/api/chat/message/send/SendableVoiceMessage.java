package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendableVoiceMessage implements SendableMessage, ReplyingOptions, NotificationOptions {

    @NonNull
    @Getter
    private final InputFile voice;
    @Getter
    private final int duration;
    @Getter
    private final long replyTo;
    @Getter
    private final ReplyMarkup replyMarkup;
    @Getter
    private final boolean disableNotification;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendableVoiceMessageBuilder object used to construct the SendableVoiceMessage object
     */
    public static SendableVoiceMessageBuilder builder() {
        return new SendableVoiceMessageBuilder();
    }

    @Override
    public MessageType getType() {

        return MessageType.VOICE;
    }

    @ToString
    public static class SendableVoiceMessageBuilder {

        private InputFile voice;
        private int duration;
        private long replyTo;
        private ReplyMarkup replyMarkup;
        private boolean disableNotification;

        SendableVoiceMessageBuilder() {
        }

        public SendableVoiceMessage.SendableVoiceMessageBuilder voice(InputFile voice) {
            this.voice = voice;
            return this;
        }

        public SendableVoiceMessage.SendableVoiceMessageBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public SendableVoiceMessage.SendableVoiceMessageBuilder replyTo(Message replyTo) {
            this.replyTo = replyTo != null ? replyTo.getMessageId() : 0;
            return this;
        }

        public SendableVoiceMessage.SendableVoiceMessageBuilder replyTo(long replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableVoiceMessage.SendableVoiceMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableVoiceMessage.SendableVoiceMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        public SendableVoiceMessage build() {
            return new SendableVoiceMessage(voice, duration, replyTo, replyMarkup, disableNotification);
        }
    }
}
