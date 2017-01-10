package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.internal.chat.inline.GameInlineCallbackQueryImpl;
import pro.zackpollard.telegrambot.api.internal.chat.inline.InlineCallbackQueryImpl;
import pro.zackpollard.telegrambot.api.internal.chat.message.GameMessageMessageCallbackQueryImpl;
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
    private final String chatInstance;

    private final JSONObject jsonCallbackQuery;

    private final TelegramBot telegramBot;

    protected CallbackQueryImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.id = jsonObject.getString("id");
        this.from = UserImpl.createUser(jsonObject.getJSONObject("from"));
        this.data = jsonObject.optString("data");
        this.chatInstance = jsonObject.getString("chat_instance");

        this.jsonCallbackQuery = jsonObject;

        this.telegramBot = telegramBot;
    }

    public static CallbackQuery createCallbackQuery(JSONObject jsonObject, TelegramBot telegramBot) {

        CallbackQuery callbackQuery = null;
        if (jsonObject != null) {

            if (!jsonObject.isNull("message")) {

                if(!jsonObject.isNull("game_short_name")) {

                    callbackQuery = GameMessageMessageCallbackQueryImpl.createGameCallbackQuery(jsonObject, telegramBot);
                } else {

                    callbackQuery = MessageCallbackQueryImpl.createCallbackQuery(jsonObject, telegramBot);
                }
            } else if (!jsonObject.isNull("inline_message_id")) {

                if(!jsonObject.isNull("game_short_name")) {

                    callbackQuery = GameInlineCallbackQueryImpl.createGameInlineCallbackQuery(jsonObject, telegramBot);
                } else {

                    callbackQuery = InlineCallbackQueryImpl.createInlineCallbackQuery(jsonObject, telegramBot);
                }
            } else {

                callbackQuery = new CallbackQueryImpl(jsonObject, telegramBot);

                System.err.println("The Telegram Bot API didn't return a Message or Inline Message ID for the CallbackQuery, send @zackpollard the following output or create a github issue.");
                System.err.println(callbackQuery.asJson().toString(4));
            }
        }

        return callbackQuery;
    }

    @Override
    public TelegramBot getBotInstance() {
        return telegramBot;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getChatInstance() {
        return chatInstance;
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
