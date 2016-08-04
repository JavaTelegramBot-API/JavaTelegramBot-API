package pro.zackpollard.telegrambot.api.chat.inline.send.content;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.message.send.ParseMode;

/**
 * @author zackp
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InputTextMessageContent implements InputMessageContent {

    @NonNull
    private final String message_text;
    private final ParseMode parse_mode;
    private final boolean disable_web_page_preview;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InputTextMessageContentBuilder object used to construct the InputTextMessageContent object
     */
    public static InputTextMessageContentBuilder builder() {
        return new InputTextMessageContentBuilder();
    }

    /**
     * Gets the text of this message
     *
     * @return The text of this message
     */
    @NonNull
    public String getMessageText() {
        return this.message_text;
    }

    /**
     * Gets the ParseMode used for this message
     *
     * @return The ParseMode used for this message
     */
    public ParseMode getParseMode() {
        return this.parse_mode;
    }

    /**
     * Gets whether the web page preview is disabled for this message
     *
     * @return True if web preview is disabled, otherwise False
     */
    public boolean isDisableWebPagePreview() {
        return this.disable_web_page_preview;
    }

    /**
     * Gets the type of InputMessageContent that this object represents
     *
     * @return The InputMessageContentType of this object
     */
    @Override
    public InputMessageContentType getType() {
        return InputMessageContentType.TEXT;
    }

    /**
     * The builder for the InputTextMessageContent object
     */
    @ToString
    public static class InputTextMessageContentBuilder {

        private String message_text;
        private ParseMode parse_mode = ParseMode.NONE;
        private boolean disable_web_page_preview = false;

        InputTextMessageContentBuilder() {
        }

        /**
         * *Required*
         * Sets the text for the message to the provided value
         *
         * @param messageText The text for the message
         *
         * @return The builder object
         */
        public InputTextMessageContent.InputTextMessageContentBuilder messageText(String messageText) {
            this.message_text = messageText;
            return this;
        }

        /**
         * *Optional*
         * Sets the ParseMode for the message to the provided value. Defaults to NONE if not set
         *
         * @param parseMode The ParseMode for the message
         *
         * @return The builder object
         */
        public InputTextMessageContent.InputTextMessageContentBuilder parseMode(ParseMode parseMode) {
            this.parse_mode = parseMode;
            return this;
        }

        /**
         * *Optional*
         * Sets whether to disable web page previews for the message. Defaults to False if not set
         *
         * @param disableWebPagePreview True to disable previews for the message, false to leave them enabled
         *
         * @return The builder object
         */
        public InputTextMessageContent.InputTextMessageContentBuilder disableWebPagePreview(boolean disableWebPagePreview) {
            this.disable_web_page_preview = disableWebPagePreview;
            return this;
        }

        /**
         * Builds the InputTextMessageContent object
         *
         * @return An InputTextMessageContent object based on the previous values
         */
        public InputTextMessageContent build() {
            return new InputTextMessageContent(message_text, parse_mode, disable_web_page_preview);
        }
    }
}