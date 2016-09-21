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
    @Getter
    private final String caption;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendableVoiceMessageBuilder object used to construct the SendableVoiceMessage object
     */
    public static SendableVoiceMessageBuilder builder() {
        return new SendableVoiceMessageBuilder();
    }

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
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
        private String caption;

        SendableVoiceMessageBuilder() {
        }

        /**
         * *Required*
         * Sets the voice recording InputFile to be sent
         *
         * @param voice The voice recording InputFile
         *
         * @return The builder object
         */
        public SendableVoiceMessage.SendableVoiceMessageBuilder voice(InputFile voice) {
            this.voice = voice;
            return this;
        }

        /**
         * *Optional*
         * Sets the duration of the voice recording file to be sent
         *
         * @param duration The duration of the voice recording file
         *
         * @return The builder object
         */
        public SendableVoiceMessage.SendableVoiceMessageBuilder duration(int duration) {
            this.duration = duration;
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
        public SendableVoiceMessage.SendableVoiceMessageBuilder replyTo(Message replyTo) {
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
        public SendableVoiceMessage.SendableVoiceMessageBuilder replyTo(long replyTo) {
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
        public SendableVoiceMessage.SendableVoiceMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
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
        public SendableVoiceMessage.SendableVoiceMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        public SendableVoiceMessage.SendableVoiceMessageBuilder caption(String caption) {

            this.caption = caption;
            return this;
        }

        /**
         * Builds the SendableVoiceMessage object
         *
         * @return A SendableVoiceMessage object based on the previously provided values
         */
        public SendableVoiceMessage build() {
            return new SendableVoiceMessage(voice, duration, replyTo, replyMarkup, disableNotification, caption);
        }
    }
}
