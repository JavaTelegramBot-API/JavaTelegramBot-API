package pro.zackpollard.telegrambot.api.keyboards;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.games.CallbackGame;

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
    private final CallbackGame callback_game;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineKeyboardButtonBuilder object used to construct the InlineKeyboardButton object
     */
    public static InlineKeyboardButtonBuilder builder() {
        return new InlineKeyboardButtonBuilder();
    }

    /**
     * Gets the text that this InlineKeyboardButton will have
     *
     * @return The text that this InlineKeyboardButton will have
     */
    public String getText() {
        return this.text;
    }

    /**
     * Gets the URL that this InlineKeyboardButton will link to when clicked
     *
     * @return The URL that this InlineKeyboardButton will link to when clicked
     */
    public String getUrl() {
        return url;
    }

    /**
     * Gets the String of callback data that this button will send back when clicked
     *
     * @return The String of callback data that this button will send back when clicked
     */
    public String getCallbackData() {
        return callback_data;
    }

    /**
     * Gets the String that will be inserted as an inline query when the button is clicked. If blank then the button
     * won't switch the user to the chat select screena dn then insert the inline query
     *
     * @return The String that will be inserted as an inline query
     */
    public String getSwitchInlineQuery() {
        return switch_inline_query;
    }

    /**
     * Description of the game that will be launched when the user presses the button.
     * NOTE: This is currently just a placeholder for when telegram implements the CallbackGame functionality
     * NOTE: This type of button must always be the first button in the first row.
     *
     * @return The CallbackGame that will be sent with this button
     */
    public CallbackGame getCallbackGame() {
        return callback_game;
    }

    @ToString
    public static class InlineKeyboardButtonBuilder {
        private String text = null;
        private String url = null;
        private String callback_data = null;
        private String switch_inline_query = null;
        private CallbackGame callback_game = null;

        InlineKeyboardButtonBuilder() {
        }

        /**
         * *Required*
         * Sets the text that will be displayed on this button
         *
         * @param text The text that will be displayed on this button
         *
         * @return The builder object
         */
        public InlineKeyboardButton.InlineKeyboardButtonBuilder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * *Optional*
         * Sets the HTTP url to be opened when button is pressed
         *
         * @param url The HTTP url to be opened when button is pressed
         *
         * @return The builder object
         */
        public InlineKeyboardButton.InlineKeyboardButtonBuilder url(String url) {
            this.url = url;
            this.callback_data = null;
            this.switch_inline_query = null;
            this.callback_game = null;
            return this;
        }

        /**
         * *Optional*
         * Sets the data to be sent in a callback query to the bot when button is pressed, 1-64 bytes
         *
         * @param callbackData The data to be sent in a callbackquery to the bot when button is pressed, 1-64 bytes
         *
         * @return The builder object
         */
        public InlineKeyboardButton.InlineKeyboardButtonBuilder callbackData(String callbackData) {
            this.callback_data = callbackData;
            this.url = null;
            this.switch_inline_query = null;
            this.callback_game = null;
            return this;
        }

        /**
         * *Optional*
         * Sets the inline query switch text. If set, pressing the button will prompt the user to select one of their
         * chats, open that chat and insert the bot‘s username and the specified inline query in the input field.
         * Can be empty, in which case just the bot’s username will be inserted.
         *
         * @param switchInlineQuery The inline query switch text
         *
         * @return The builder object
         */
        public InlineKeyboardButton.InlineKeyboardButtonBuilder switchInlineQuery(String switchInlineQuery) {
            this.switch_inline_query = switchInlineQuery;
            this.url = null;
            this.callback_data = null;
            this.callback_game = null;
            return this;
        }

        /**
         * *Optional*
         * Sets the CallbackGame object that will be sent with this button.
         * NOTE: This will currently do nothing as this is just placeholder for when telegram implements the
         * CallbackGame object
         *
         * @param callbackGame The inline query switch text
         *
         * @return The builder object
         */
        public InlineKeyboardButton.InlineKeyboardButtonBuilder callbackGame(CallbackGame callbackGame) {
            /*
            this.callback_game = callbackGame;
            this.url = null;
            this.callback_data = null;
            this.switch_inline_query = null;
            */
            return this;
        }

        /**
         * Builds the InlineKeyboardButton object
         *
         * @return A InlineKeyboardButton object based on the previously provided values
         */
        public InlineKeyboardButton build() {
            return new InlineKeyboardButton(text, url, callback_data, switch_inline_query, callback_game);
        }
    }
}
