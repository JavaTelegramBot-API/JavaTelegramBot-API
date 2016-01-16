package pro.zackpollard.telegrambot.api.chat.inline;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public interface ChosenInlineResult {

    String getResultId();

    User getSender();

    String getQuery();

    JSONObject asJson();
}
