package pro.zackpollard.telegrambot.api.keyboards;

import lombok.NonNull;

/**
 * @author zackp
 */

public class InlineKeyboardButton {

    @NonNull
    private final String text;
    private final String url;
    private final String callback_data;
    private final String switch_inline_query;

    private InlineKeyboardButton(String text, String url, String callback_data, String switch_inline_query) {
        this.text = text;
        this.url = url;
        this.callback_data = callback_data;
        this.switch_inline_query = switch_inline_query;
    }

    public static InlineKeyboardButtonBuilder builder() {
        return new InlineKeyboardButtonBuilder();
    }

    public String getText() {
        return this.text;
    }

    public static class InlineKeyboardButtonBuilder {
        private String text;
        private String url;
        private String callback_data;
        private String switch_inline_query;

        InlineKeyboardButtonBuilder() {
        }

        public InlineKeyboardButton.InlineKeyboardButtonBuilder text(String text) {
            this.text = text;
            return this;
        }

        public InlineKeyboardButton.InlineKeyboardButtonBuilder url(String url) {
            this.url = url;
            return this;
        }

        public InlineKeyboardButton.InlineKeyboardButtonBuilder callbackData(String callbackData) {
            this.callback_data = callbackData;
            return this;
        }

        public InlineKeyboardButton.InlineKeyboardButtonBuilder switchInlineQuery(String switchInlineQuery) {
            this.switch_inline_query = switchInlineQuery;
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
