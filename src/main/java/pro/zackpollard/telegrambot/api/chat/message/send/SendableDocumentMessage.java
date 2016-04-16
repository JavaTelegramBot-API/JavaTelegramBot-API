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
public class SendableDocumentMessage implements SendableMessage, ReplyingOptions, NotificationOptions {

    @NonNull
    @Getter
    private final InputFile document;
    @Getter
    private final long replyTo;
    @Getter
    private final ReplyMarkup replyMarkup;
    @Getter
    private final boolean disableNotification;
    @Getter
    private final String caption;

    public static SendableDocumentMessageBuilder builder() {
        return new SendableDocumentMessageBuilder();
    }

    @Override
    public MessageType getType() {
        return MessageType.DOCUMENT;
    }

    public static class SendableDocumentMessageBuilder {

        private InputFile document;
        private long replyTo;
        private ReplyMarkup replyMarkup;
        private boolean disableNotification;
        private String caption;

        SendableDocumentMessageBuilder() {
        }

        public SendableDocumentMessage.SendableDocumentMessageBuilder document(InputFile document) {
            this.document = document;
            return this;
        }

        public SendableDocumentMessage.SendableDocumentMessageBuilder replyTo(Message replyTo) {
            this.replyTo = replyTo != null ? replyTo.getMessageId() : 0;
            return this;
        }

        public SendableDocumentMessage.SendableDocumentMessageBuilder replyTo(long replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableDocumentMessage.SendableDocumentMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableDocumentMessage.SendableDocumentMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        public SendableDocumentMessage.SendableDocumentMessageBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public SendableDocumentMessage build() {
            return new SendableDocumentMessage(document, replyTo, replyMarkup, disableNotification, caption);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableDocumentMessage.SendableDocumentMessageBuilder(document=" + this.document + ", replyTo=" + this.replyTo + ", replyMarkup=" + this.replyMarkup + ")";
        }
    }
}