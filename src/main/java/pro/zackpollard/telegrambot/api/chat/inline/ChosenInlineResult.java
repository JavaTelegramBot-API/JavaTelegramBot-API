package pro.zackpollard.telegrambot.api.chat.inline;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Location;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public interface ChosenInlineResult {

    String getResultId();

    User getSender();

    Location getLocation();

    String getInlineMessageId();

    String getQuery();

    JSONObject asJson();
}
