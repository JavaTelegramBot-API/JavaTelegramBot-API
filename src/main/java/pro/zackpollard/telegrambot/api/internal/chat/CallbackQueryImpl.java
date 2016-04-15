package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.internal.chat.inline.InlineCallbackQueryImpl;
import pro.zackpollard.telegrambot.api.internal.chat.message.MessageCallbackQueryImpl;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public class CallbackQueryImpl implements CallbackQuery {

    private final String id;
    private final User from;
    private final String data;

    private final JSONObject jsonCallbackQuery;

    protected CallbackQueryImpl(JSONObject jsonObject) {

        this.id = jsonObject.getString("id");
        this.from = UserImpl.createUser(jsonObject.getJSONObject("from"));
        this.data = jsonObject.getString("data");

        this.jsonCallbackQuery = jsonObject;
    }

    public static CallbackQuery createCallbackQuery(JSONObject jsonObject) {

        CallbackQuery callbackQuery = null;
        if(jsonObject != null) {

            if(!jsonObject.isNull("message")) {

                callbackQuery = MessageCallbackQueryImpl.createMessageCallbackQuery(jsonObject);
            } else if(!jsonObject.isNull("inline_message_id")) {

                callbackQuery = InlineCallbackQueryImpl.createInlineCallbackQuery(jsonObject);
            } else {

                callbackQuery = new CallbackQueryImpl(jsonObject);

                System.err.println("The Telegram Bot API didn't return a Message or Inline Message ID for the CallbackQuery, send @zackpollard the following output or create a github issue.");
                System.err.println(callbackQuery.asJson().toString(4));
            }
        }

        return callbackQuery;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public User getFrom() {
        return this.from;
    }

    @Override
    public String getData() {
        return this.data;
    }

    @Override
    public JSONObject asJson() {
        return jsonCallbackQuery;
    }
}
