package pro.zackpollard.telegrambot.api.internal.chat.inline;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.inline.InlineQuery;
import pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResult;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public class InlineQueryImpl implements InlineQuery {

    private final String id;
    private final User from;
    private final String query;
    private final String offset;

    private InlineQueryImpl(JSONObject jsonObject) {

        this.id = jsonObject.getString("id");
        this.from = UserImpl.createUser(jsonObject.getJSONObject("from"));
        this.query = jsonObject.getString("query");
        this.offset = jsonObject.getString("offset");
    }

    public static InlineQuery createInlineQuery(JSONObject jsonObject) {

        return jsonObject != null ? new InlineQueryImpl(jsonObject) : null;
    }

    @Override
    public String getQueryId() {
        return id;
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
    public String getOffset() {

        return offset;
    }
}
