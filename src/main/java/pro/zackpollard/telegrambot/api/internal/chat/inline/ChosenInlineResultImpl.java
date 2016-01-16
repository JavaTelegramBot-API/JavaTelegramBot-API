package pro.zackpollard.telegrambot.api.internal.chat.inline;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.inline.ChosenInlineResult;
import pro.zackpollard.telegrambot.api.chat.inline.InlineQuery;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public class ChosenInlineResultImpl implements ChosenInlineResult {

    private final JSONObject jsonChosenInlineResult;

    private final String result_id;
    private final User from;
    private final String query;

    private ChosenInlineResultImpl(JSONObject jsonObject) {

        this.jsonChosenInlineResult = jsonObject;

        this.result_id = jsonObject.getString("result_id");
        this.from = UserImpl.createUser(jsonObject.getJSONObject("from"));
        this.query = jsonObject.getString("query");
    }

    public static ChosenInlineResult createChosenInlineResult(JSONObject jsonObject) {

        return jsonObject != null ? new ChosenInlineResultImpl(jsonObject) : null;
    }

    @Override
    public String getResultId() {
        return result_id;
    }

    @Override
    public User getSender() {
        return from;
    }

    @Override
    public String getQuery() {
        return query;
    }

    @Override
    public JSONObject asJson() {
        return jsonChosenInlineResult;
    }
}
