package pro.zackpollard.telegrambot.api.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author zackp
 */
public interface CallbackQuery {

    TelegramBot getBotInstance();

    String getId();

    default CallbackQueryType getType() {

        return CallbackQueryType.UNKNOWN;
    }

    User getFrom();

    String getData();

    JSONObject asJson();

    default boolean answer(String text, boolean showAlert) {

        return getBotInstance().answerCallbackQuery(getId(), text, showAlert);
    }
}