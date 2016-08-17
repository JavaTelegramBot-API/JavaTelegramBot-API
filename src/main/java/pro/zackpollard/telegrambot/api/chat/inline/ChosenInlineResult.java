package pro.zackpollard.telegrambot.api.chat.inline;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Location;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public interface ChosenInlineResult {

    /**
     * Gets the result ID for the chosen inline result
     *
     * @return The result ID
     */
    String getResultId();

    /**
     * Gets the User that chose the result
     *
     * @return The User that chose the result
     */
    User getSender();

    /**
     * Gets the location of the User that chose the result
     *
     * @return The location of the User or null if no Location was sent
     */
    Location getLocation();

    /**
     * Gets the ID of the sent inline message relating to this result
     *
     * @return The ID of the sent inline message
     */
    String getInlineMessageId();

    /**
     * Gets the original query that was sent to produce this result
     *
     * @return The query that was originally sent
     */
    String getQuery();

    /**
     * Gets the JSONObject that was sent by the bot API to produce this object
     *
     * @return The JSONObject version of this object
     */
    JSONObject asJson();
}
