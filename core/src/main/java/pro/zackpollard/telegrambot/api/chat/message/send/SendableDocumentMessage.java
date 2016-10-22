package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
@ToString
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

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendableDocumentMessageBuilder object used to construct the SendableDocumentMessage object
     */
    public static SendableDocumentMessageBuilder builder() {
        return new SendableDocumentMessageBuilder();
    }

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
    @Override
    public MessageType getType() {
        return MessageType.DOCUMENT;
    }

    @ToString
    public static class SendableDocumentMessageBuilder {

        private InputFile document;
        private long replyTo;
        private ReplyMarkup replyMarkup;
        private boolean disableNotification;
        private String caption;

        SendableDocumentMessageBuilder() {
        }

        /**
         * *Required*
         * Sets the document InputFile to be sent
         *
         * @param document The document InputFile
         *
         * @return The builder object
         */
        public SendableDocumentMessage.SendableDocumentMessageBuilder document(InputFile document) {
            this.document = document;
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
        public SendableDocumentMessage.SendableDocumentMessageBuilder replyTo(Message replyTo) {
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
        public SendableDocumentMessage.SendableDocumentMessageBuilder replyTo(long replyTo) {
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
        public SendableDocumentMessage.SendableDocumentMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
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
        public SendableDocumentMessage.SendableDocumentMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
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
        public SendableDocumentMessage.SendableDocumentMessageBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        /**
         * Builds the SendableDocumentMessage object
         *
         * @return A SendableDocumentMessage object based on the previously provided values
         */
        public SendableDocumentMessage build() {
            return new SendableDocumentMessage(document, replyTo, replyMarkup, disableNotification, caption);
        }
    }
}