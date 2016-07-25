package pro.zackpollard.telegrambot.api.keyboards;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author zackp
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineKeyboardButton {

    @NonNull
    private final String text;
    private final String url;
    private final String callback_data;
    private final String switch_inline_query;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineKeyboardButtonBuilder object used to construct the InlineKeyboardButton object
     */
    public static InlineKeyboardButtonBuilder builder() {
        return new InlineKeyboardButtonBuilder();
    }

    public String getText() {
        return this.text;
    }

    public String getUrl() {
        return url;
    }

    public String getCallbackData() {
        return callback_data;
    }

    public String getSwitchInlineQuery() {
        return switch_inline_query;
    }

    @ToString
    public static class InlineKeyboardButtonBuilder {
        private String text = null;
        private String url = null;
        private String callback_data = null;
        private String switch_inline_query = null;

        InlineKeyboardButtonBuilder() {
        }

        public InlineKeyboardButton.InlineKeyboardButtonBuilder text(String text) {
            this.text = text;
            return this;
        }

        public InlineKeyboardButton.InlineKeyboardButtonBuilder url(String url) {
            this.url = url;
            this.callback_data = null;
            this.switch_inline_query = null;
            return this;
        }

        public InlineKeyboardButton.InlineKeyboardButtonBuilder callbackData(String callbackData) {
            this.callback_data = callbackData;
            this.url = null;
            this.switch_inline_query = null;
            return this;
        }

        public InlineKeyboardButton.InlineKeyboardButtonBuilder switchInlineQuery(String switchInlineQuery) {
            this.switch_inline_query = switchInlineQuery;
            this.url = null;
            this.callback_data = null;
            return this;
        }

        public InlineKeyboardButton build() {
            return new InlineKeyboardButton(text, url, callback_data, switch_inline_query);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton.InlineKeyboardButtonBuilder(text=" + this.text + ", url=" + this.url + ", callbackData=" + this.callback_data + ", switchInlineQuery=" + this.switch_inline_query + ")";
        }
    }
}
