package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendableVideoMessage implements SendableMessage, ReplyingOptions, NotificationOptions {

    @NonNull
    @Getter
    private final InputFile video;
    @Getter
    private final int duration;
    @Getter
    private final int width;
    @Getter
    private final int height;
    @Getter
    private final String caption;
    @Getter
    private final long replyTo;
    @Getter
    private final ReplyMarkup replyMarkup;
    @Getter
    private final boolean disableNotification;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendableVideoMessageBuilder object used to construct the SendableVideoMessage object
     */
    public static SendableVideoMessageBuilder builder() {
        return new SendableVideoMessageBuilder();
    }

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
    @Override
    public MessageType getType() {
        return MessageType.VIDEO;
    }

    @ToString
    public static class SendableVideoMessageBuilder {

        private InputFile video;
        private int duration;
        private int width;
        private int height;
        private String caption;
        private long replyTo;
        private ReplyMarkup replyMarkup;
        private boolean disableNotification;

        SendableVideoMessageBuilder() {
        }

        /**
         * *Required*
         * Sets the video InputFile to be sent
         *
         * @param video The video InputFile
         *
         * @return The builder object
         */
        public SendableVideoMessage.SendableVideoMessageBuilder video(InputFile video) {
            this.video = video;
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
        public SendableVideoMessage.SendableVideoMessageBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        /**
         * *Optional*
         * Sets the width of the video file to be sent
         *
         * @param width The width of the video file
         *
         * @return The builder object
         */
        public SendableVideoMessage.SendableVideoMessageBuilder width(int width) {
            this.width = width;
            return this;
        }

        /**
         * *Optional*
         * Sets the height of the video file to be sent
         *
         * @param height The height of the video file
         *
         * @return The builder object
         */
        public SendableVideoMessage.SendableVideoMessageBuilder height(int height) {
            this.height = height;
            return this;
        }

        /**
         * *Optional*
         * Sets the caption that you want to send with the Message
         *
         * @param caption The caption you want to send with the Message
         *
         * @return The builder object
         */
        public SendableVideoMessage.SendableVideoMessageBuilder caption(String caption) {
            this.caption = caption;
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
        public SendableVideoMessage.SendableVideoMessageBuilder replyTo(Message replyTo) {
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
        public SendableVideoMessage.SendableVideoMessageBuilder replyTo(long replyTo) {
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
        public SendableVideoMessage.SendableVideoMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
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
        public SendableVideoMessage.SendableVideoMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        /**
         * Builds the SendableVideoMessage object
         *
         * @return A SendableVideoMessage object based on the previously provided values
         */
        public SendableVideoMessage build() {
            return new SendableVideoMessage(video, duration, width, height, caption, replyTo, replyMarkup, disableNotification);
        }
    }
}