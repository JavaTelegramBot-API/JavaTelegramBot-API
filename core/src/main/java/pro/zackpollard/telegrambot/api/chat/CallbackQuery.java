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
     * @return The data that was originall sent with the button used to trigger this CallbackQuery
     */
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