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

        public SendableVideoMessage.SendableVideoMessageBuilder video(InputFile video) {
            this.video = video;
            return this;
        }

        public SendableVideoMessage.SendableVideoMessageBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public SendableVideoMessage.SendableVideoMessageBuilder width(int width) {
            this.width = width;
            return this;
        }

        public SendableVideoMessage.SendableVideoMessageBuilder height(int height) {
            this.height = height;
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

        public SendableVideoMessage.SendableVideoMessageBuilder replyTo(long replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableVideoMessage.SendableVideoMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableVideoMessage.SendableVideoMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        public SendableVideoMessage build() {
            return new SendableVideoMessage(video, duration, width, height, caption, replyTo, replyMarkup, disableNotification);
        }
    }
}