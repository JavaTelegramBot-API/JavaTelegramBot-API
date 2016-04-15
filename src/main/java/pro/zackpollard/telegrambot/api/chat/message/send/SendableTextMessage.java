package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendableTextMessage implements SendableMessage, ReplyingOptions, NotificationOptions {

    @NonNull
    @Getter
    private final String message;
    @Getter
    private final int replyTo;
    @Getter
    private final boolean disableWebPagePreview;
    @Getter
    private final ReplyMarkup replyMarkup;
    @Getter
    private final ParseMode parseMode;
    @Getter
    private final boolean disableNotification;

    public static SendableTextMessageBuilder builder() {
        return new SendableTextMessageBuilder();
    }

    @Override
    public MessageType getType() {
        return MessageType.TEXT;
    }

    public static class SendableTextMessageBuilder {

        private String message;
        private int replyTo;
        private boolean disableWebPagePreview;
        private ReplyMarkup replyMarkup;
        private ParseMode parseMode;
        private boolean disableNotification;

        SendableTextMessageBuilder() {
        }

        public SendableTextMessage.SendableTextMessageBuilder message(String message) {
            this.message = message;
            return this;
        }

        public SendableTextMessage.SendableTextMessageBuilder replyTo(Message replyTo) {
            this.replyTo = replyTo != null ? replyTo.getMessageId() : 0;
            return this;
        }

        public SendableTextMessage.SendableTextMessageBuilder replyTo(int replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableTextMessage.SendableTextMessageBuilder disableWebPagePreview(boolean disableWebPagePreview) {
            this.disableWebPagePreview = disableWebPagePreview;
            return this;
        }

        public SendableTextMessage.SendableTextMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableTextMessage.SendableTextMessageBuilder parseMode(ParseMode parseMode) {
            this.parseMode = parseMode;
            return this;
        }

        public SendableTextMessage.SendableTextMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        public SendableTextMessage build() {
            return new SendableTextMessage(message, replyTo, disableWebPagePreview, replyMarkup, parseMode, disableNotification);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableTextMessage.SendableTextMessageBuilder(message=" + this.message + ", replyTo=" + this.replyTo + ", disableWebPagePreview=" + this.disableWebPagePreview + ", replyMarkup=" + this.replyMarkup + ", parseMode=" + this.parseMode + ")";
        }
    }
}