package pro.zackpollard.telegrambot.api.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author zackp
 */
public interface CallbackQuery {

    String getId();

    default CallbackQueryType getType() {

        return CallbackQueryType.UNKNOWN;
    }

    User getFrom();

    String getData();

    JSONObject asJson();
}
