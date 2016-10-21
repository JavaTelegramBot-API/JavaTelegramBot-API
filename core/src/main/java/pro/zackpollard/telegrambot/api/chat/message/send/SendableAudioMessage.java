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
    @Getter
    private final String caption;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendableAudioMessageBuilder object used to construct the SendableAudioMessage object
     */
    public static SendableAudioMessageBuilder builder() {
        return new SendableAudioMessageBuilder();
    }

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
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
        private String caption;

        SendableAudioMessageBuilder() {
        }

        /**
         * *Required*
         * Sets the audio InputFile to be sent
         *
         * @param audio The audio InputFile
         *
         * @return The builder object
         */
        public SendableAudioMessage.SendableAudioMessageBuilder audio(InputFile audio) {
            assert audio != null;
            this.audio = audio;
            return this;
        }

        /**
         * *Optional*
         * Sets the duration of the audio file to be sent
         *
         * @param duration The duration of the audio file
         *
         * @return The builder object
         */
        public SendableAudioMessage.SendableAudioMessageBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        /**
         * *Optional*
         * Sets the performer of the audio file to be sent
         *
         * @param performer The performer of the audio file
         *
         * @return The builder object
         */
        public SendableAudioMessage.SendableAudioMessageBuilder performer(String performer) {
            this.performer = performer;
            return this;
        }

        /**
         * *Optional*
         * Sets the title of the audio file to be sent
         *
         * @param title The title of the audio file
         *
         * @return The builder object
         */
        public SendableAudioMessage.SendableAudioMessageBuilder title(String title) {
            this.title = title;
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
        public SendableAudioMessage.SendableAudioMessageBuilder replyTo(Message replyTo) {
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
        public SendableAudioMessage.SendableAudioMessageBuilder replyTo(long replyTo) {
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
        public SendableAudioMessage.SendableAudioMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
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
        public SendableAudioMessage.SendableAudioMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        /**
         * *Optional*
         * Sets the caption to be sent with the message
         *
         * @param caption The caption to be sent with the message
         *
         * @return The builder object
         */
        public SendableAudioMessage.SendableAudioMessageBuilder caption(String caption) {

            this.caption = caption;
            return this;
        }

        /**
         * Builds the SendableAudioMessage object
         *
         * @return A SendableAudioMessage object based on the previously provided values
         */
        public SendableAudioMessage build() {
            return new SendableAudioMessage(audio, duration, performer, title, replyTo, replyMarkup, disableNotification, caption);
        }
    }
}