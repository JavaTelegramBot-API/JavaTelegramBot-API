package pro.zackpollard.telegrambot.api.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author zackp
 */
public interface CallbackQuery {

    /**
     * Gets the TelegramBot instance associated with this CallbackQuery
     *
     * @return The TelegramBot instance associated with this CallbackQuery
     */
    TelegramBot getBotInstance();

    /**
     * Gets the ID of this CallbackQuery
     *
     * @return The ID of this CallbackQuery
     */
    String getId();

    /**
     * Gets the unique identifier for the chat instance that this game callback query is being sent from
     *
     * @return The unique identifier for the chat this is from
     */
    String getChatInstance();

    /**
     * Gets the CallbackQueryType for this callback query
     *
     * @return The CallbackQueryType for this callback query
     */
    default CallbackQueryType getType() {

        return CallbackQueryType.UNKNOWN;
    }

    /**
     * Gets who triggered the CallbackQuery
     *
     * @return The User who triggered the CallbackQuery
     */
    User getFrom();

    /**
     * Gets the data that was originally sent with the button used to trigger this CallbackQuery
     *
     * @deprecated This method is deprecated in favour of the more specific CallbackQuery objects, as it can sometimes
     * be null here.
     * @return The data that was original sent with the button used to trigger this CallbackQuery, or null
     */
    @Deprecated
    String getData();

    /**
     * Gets the JSON representation of this CallbackQuery object as received from the Telegram Bot API
     *
     * @return The JSON representation of this CallbackQuery object as received from the Telegram Bot API
     */
    JSONObject asJson();

    /**
     * This method is used to directly answer the CallbackQuery without having to call other methods outside this object
     *
     * @param text          The text you would like to send in response to this CallbackQuery
     * @param showAlert     Whether to show this as an alert or a toast. The default is a toast
     *
     * @return True if the answer was sent successfully, otherwise False
     */
    default boolean answer(String text, boolean showAlert) {

        return getBotInstance().answerCallbackQuery(getId(), text, showAlert);
    }
}