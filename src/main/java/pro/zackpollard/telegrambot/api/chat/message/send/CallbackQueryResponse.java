package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.net.URL;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CallbackQueryResponse {

    @NonNull
    private final String text;
    private final boolean show_alert;
    private final URL url;
    private final Integer cache_time;

    public static CallbackQueryResponseBuilder builder() {
        return new CallbackQueryResponseBuilder();
    }

    /**
     * Gets a the text that will be sent with this response
     *
     * @return The text that will be sent with this response
     */
    @NonNull
    public String getText() {
        return this.text;
    }

    /**
     * If true, an alert will be shown by the client instead of a notification at the top of the chat screen.
     * Defaults to false.
     *
     * @return Whether an alert will be shown rather than a notification
     */
    public boolean isShowAlert() {
        return this.show_alert;
    }

    /**
     * URL that will be opened by the user's client. If you have created a Game and accepted the conditions via
     * @Botfather, specify the URL that opens your game – note that this will only work if the query comes from a
     * callback_game button.
     * Otherwise, you may use links like telegram.me/your_bot?start=XXXX that open your bot with a parameter.
     *
     * @return The url you are sending with this CallbackQueryResponse
     */
    public URL getURL() {
        return this.url;
    }

    /**
     * The maximum amount of time in seconds that the result of the callback query may be cached client-side.
     * Telegram apps will support caching starting in version 3.14.
     * Defaults to 0.
     *
     * @return The maximum time that this response will be cached by the client
     */
    public Integer getCacheTime() {
        return this.cache_time;
    }

    @ToString
    public static class CallbackQueryResponseBuilder {
        private String text;
        private boolean show_alert;
        private URL url;
        private Integer cache_time;

        CallbackQueryResponseBuilder() {
        }

        /**
         * *Optional*
         * Sets the text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
         *
         * @param text The text of the notification to be sent
         *
         * @return The builder object
         */
        public CallbackQueryResponse.CallbackQueryResponseBuilder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * *Optional*
         * Sets whether an alert will be shown by the client instead of a notification at the top of the chat screen.
         *
         * @param showAlert True if an alert will be shown, false if a notification will be shown
         *
         * @return The builder object
         */
        public CallbackQueryResponse.CallbackQueryResponseBuilder showAlert(boolean showAlert) {
            this.show_alert = showAlert;
            return this;
        }

        /**
         * *Optional*
         * Sets the URL that will be opened by the user's client. If you have created a Game and accepted the conditions
         * via @Botfather, specify the URL that opens your game – note that this will only work if the query comes
         * from a callback_game button.
         * Otherwise, you may use links like telegram.me/your_bot?start=XXXX that open your bot with a parameter.
         *
         * @param url The URL you want to open when this CallbackQueryResponse is sent
         *
         * @return The builder object
         */
        public CallbackQueryResponse.CallbackQueryResponseBuilder url(URL url) {
            this.url = url;
            return this;
        }

        /**
         * *Optional*
         * Sets the maximum amount of time in seconds that the result of the callback query may be cached client-side.
         *
         * @param cacheTime The cache time for this response
         *
         * @return The builder object
         */
        public CallbackQueryResponse.CallbackQueryResponseBuilder cacheTime(Integer cacheTime) {
            this.cache_time = cacheTime;
            return this;
        }

        /**
         * Builds the CallbackQueryResponse object
         *
         * @return A CallbackQueryResponse object based on the previously provided values
         */
        public CallbackQueryResponse build() {
            return new CallbackQueryResponse(text, show_alert, url, cache_time);
        }
    }
}
