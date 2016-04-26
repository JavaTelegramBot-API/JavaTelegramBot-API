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

    public static InputTextMessageContentBuilder builder() {
        return new InputTextMessageContentBuilder();
    }

    @NonNull
    public String getMessageText() {
        return this.message_text;
    }

    public ParseMode getParseMode() {
        return this.parse_mode;
    }

    public boolean isDisableWebPagePreview() {
        return this.disable_web_page_preview;
    }

    @Override
    public InputMessageContentType getType() {
        return InputMessageContentType.TEXT;
    }

    @ToString
    public static class InputTextMessageContentBuilder {

        private String message_text;
        private ParseMode parse_mode = ParseMode.NONE;
        private boolean disable_web_page_preview = false;

        InputTextMessageContentBuilder() {
        }

        public InputTextMessageContent.InputTextMessageContentBuilder messageText(String messageText) {
            this.message_text = messageText;
            return this;
        }

        public InputTextMessageContent.InputTextMessageContentBuilder parseMode(ParseMode parseMode) {
            this.parse_mode = parseMode;
            return this;
        }

        public InputTextMessageContent.InputTextMessageContentBuilder disableWebPagePreview(boolean disableWebPagePreview) {
            this.disable_web_page_preview = disableWebPagePreview;
            return this;
        }

        public InputTextMessageContent build() {
            return new InputTextMessageContent(message_text, parse_mode, disable_web_page_preview);
        }
    }
}