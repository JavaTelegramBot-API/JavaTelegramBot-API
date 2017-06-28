package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendableVideoNoteMessage implements SendableMessage, ReplyingOptions, NotificationOptions {

    @NonNull
    @Getter
    private final InputFile videoNote;
    @Getter
    private final int duration;
    @Getter
    private final int length;
    @Getter
    private final long replyTo;
    @Getter
    private final ReplyMarkup replyMarkup;
    @Getter
    private final boolean disableNotification;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendableVideoNoteMessageBuilder object used to construct the SendableVideoMessage object
     */
    public static SendableVideoNoteMessageBuilder builder() {
        return new SendableVideoNoteMessageBuilder();
    }

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
    @Override
    public MessageType getType() {
        return MessageType.VIDEO_NOTE;
    }

    @ToString
    public static class SendableVideoNoteMessageBuilder {

        private InputFile videoNote;
        private int duration;
        private int length;
        private long replyTo;
        private ReplyMarkup replyMarkup;
        private boolean disableNotification;

        SendableVideoNoteMessageBuilder() {
        }

        /**
         * *Required*
         * Sets the video note InputFile to be sent
         *
         * @param videoNote The video note InputFile
         *
         * @return The builder object
         */
        public SendableVideoNoteMessageBuilder video(InputFile videoNote) {
            this.videoNote = videoNote;
            return this;
        }

        /**
         * *Optional*
         * Sets the duration of the video file to be sent
         *
         * @param duration The duration of the video file
         *
         * @return The builder object
         */
        public SendableVideoNoteMessageBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        /**
         * *Optional*
         * Sets the height and width of the video file to be sent
         *
         * @param length The height and width of the video file
         *
         * @return The builder object
         */
        public SendableVideoNoteMessageBuilder length(int length) {
            this.length = length;
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
        public SendableVideoNoteMessageBuilder replyTo(Message replyTo) {
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
        public SendableVideoNoteMessageBuilder replyTo(long replyTo) {
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
        public SendableVideoNoteMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
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
        public SendableVideoNoteMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        /**
         * Builds the SendableVideoNoteMessage object
         *
         * @return A SendableVideoNoteMessage object based on the previously provided values
         */
        public SendableVideoNoteMessage build() {
            return new SendableVideoNoteMessage(videoNote, duration, length, replyTo, replyMarkup, disableNotification);
        }
    }
}