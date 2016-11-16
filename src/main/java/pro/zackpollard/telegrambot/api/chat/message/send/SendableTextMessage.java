package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendableTextMessage implements SendableMessage, ReplyingOptions, NotificationOptions {

    @NonNull
    @Getter
    private final String message;
    @Getter
    private final long replyTo;
    @Getter
    private final boolean disableWebPagePreview;
    @Getter
    private final ReplyMarkup replyMarkup;
    @Getter
    private final ParseMode parseMode;
    @Getter
    private final boolean disableNotification;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A SendableTextMessageBuilder object used to construct the SendableTextMessage object
     */
    public static SendableTextMessageBuilder builder() {
        return new SendableTextMessageBuilder();
    }

    /**
     * This builder will be created with the text you provide already added with markdown formatting enabled.
     *
     * @param text The text you would like the builder to be created with
     *
     * @return  A SendableTextMessageBuilder object with the text provided already added to it in markdown format. Used
     *          to construct the SendableTextMessage object
     */
    public static SendableTextMessageBuilder markdown(String text) {
        return builder().message(text).parseMode(ParseMode.MARKDOWN);
    }

    /**
     * This builder will be created with the text you provide already added with HTML formatting enabled.
     *
     * @param text The text you would like the builder to be created with
     *
     * @return  A SendableTextMessageBuilder object with the text provided already added to it in HTML format. Used
     *          to construct the SendableTextMessage object
     */
    public static SendableTextMessageBuilder html(String text) {
        return builder().message(text).parseMode(ParseMode.HTML);
    }

    /**
     * This builder will be created with the text you provide already added with markdown formatting enabled.
     *
     * @param text The text you would like the builder to be created with
     *
     * @return  A SendableTextMessageBuilder object with the text provided already added to it. Used to construct the
     *          SendableTextMessage object
     */
    public static SendableTextMessageBuilder plain(String text) {
        return builder().message(text).parseMode(ParseMode.NONE);
    }

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
    @Override
    public MessageType getType() {
        return MessageType.TEXT;
    }

    public static class SendableTextBuilder {
        private final SendableTextMessageBuilder parent;
        private final StringBuilder message = new StringBuilder();

        SendableTextBuilder(SendableTextMessageBuilder parent) {
            this.parent = parent;
        }

        private String htmlEscaped(String text) {
            return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
        }

        private SendableTextBuilder element(String e, String content) {
            // for the closing element, split(" ")[0] is used in case of parameters
            // that are used like linking
            message.append("<").append(e).append(">").append(htmlEscaped(content)).append("</").append(e.split(" ")[0]).append(">");
            return this;
        }

        public SendableTextBuilder plain(String text) {
            return escaped(text);
        }

        /**
         * Appends text as escaped text, no formatting.
         *
         * @param text Text to append and escape
         */
        public SendableTextBuilder escaped(String text) {
            return html(htmlEscaped(text));
        }

        /**
         * Text to take in and parse as HTML-formatted text.
         *
         * @param html Text to append and parse as HTML
         */
        public SendableTextBuilder html(String html) {
            message.append(html);
            return this;
        }

        /**
         * Appends text and makes it bold. Text is escaped.
         * @param text Text to append
         */
        public SendableTextBuilder bold(String text) {
            return element("b", text);
        }

        /**
         * Appends text and makes it italic. Text is escaped.
         * @param text Text to append
         */
        public SendableTextBuilder italics(String text) {
            return element("i", text);
        }

        /**
         * Appends an inline URL in the text
         * @param text Text to link. Text is escaped
         * @param link Link to reference
         */
        public SendableTextBuilder link(String text, String link) {
            return element("a href=\"" + link + "\"", text);
        }

        /**
         * Appends inline-code to the text
         * @param text Text to format. Escaped.
         */
        public SendableTextBuilder code(String text) {
            return element("code", text);
        }

        /**
         * Appends pre-formatted fixed-width code block.
         * @param text Text to format. Escaped
         */
        public SendableTextBuilder preformatted(String text) {
            return element("pre", text);
        }

        /**
         * Appends a space.
         */
        public SendableTextBuilder space() {
            message.append(' ');
            return this;
        }

        /**
         * Appends a new line
         */
        public SendableTextBuilder newLine() {
            message.append("\n");
            return this;
        }

        /**
         * Alias for newLine()
         */
        public SendableTextBuilder nextLine() {
            return newLine();
        }

        /**
         * Set the SendableTextMessageBuilder's text to the created text.
         * ParseMode must be HTML!
         *
         * @return SendableTextMessageBuilder instance
         */
        public SendableTextMessageBuilder buildText() {
            parent.message = message.toString();
            parent.parseMode = ParseMode.HTML;
            return parent;
        }
    }

    @ToString
    public static class SendableTextMessageBuilder {

        private String message;
        private long replyTo;
        private boolean disableWebPagePreview;
        private ReplyMarkup replyMarkup;
        private ParseMode parseMode;
        private boolean disableNotification;

        SendableTextMessageBuilder() {
        }

        public SendableTextBuilder textBuilder() {
            return new SendableTextBuilder(this);
        }

        /**
         * *Required*
         * Sets the text to be sent
         *
         * @param message The text to be sent
         *
         * @return The builder object
         */
        public SendableTextMessage.SendableTextMessageBuilder message(String message) {
            this.message = message;
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
        public SendableTextMessage.SendableTextMessageBuilder replyTo(Message replyTo) {
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
        public SendableTextMessage.SendableTextMessageBuilder replyTo(long replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableTextMessage.SendableTextMessageBuilder disableWebPagePreview(boolean disableWebPagePreview) {
            this.disableWebPagePreview = disableWebPagePreview;
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
        public SendableTextMessage.SendableTextMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        /**
         * *Optional*
         * Sets the ParseMode that you want to use for this message
         *
         * @param parseMode The ParseMode you want to use with this message
         *
         * @return The builder object
         */
        public SendableTextMessage.SendableTextMessageBuilder parseMode(ParseMode parseMode) {
            this.parseMode = parseMode;
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
        public SendableTextMessage.SendableTextMessageBuilder disableNotification(boolean disableNotification) {

            this.disableNotification = disableNotification;
            return this;
        }

        /**
         * Builds the SendableTextMessage object
         *
         * @return A SendableTextMessage object based on the previously provided values
         */
        public SendableTextMessage build() {
            return new SendableTextMessage(message, replyTo, disableWebPagePreview, replyMarkup, parseMode, disableNotification);
        }
    }
}