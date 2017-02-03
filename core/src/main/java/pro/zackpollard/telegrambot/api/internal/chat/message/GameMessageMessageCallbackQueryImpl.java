package pro.zackpollard.telegrambot.api.internal.chat.message;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.GameMessageCallbackQuery;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.internal.chat.CallbackQueryImpl;

/**
 * @author zackp
 */
public class GameMessageMessageCallbackQueryImpl extends CallbackQueryImpl implements GameMessageCallbackQuery {

    private final String gameShortName;
    private final Message message;

    private GameMessageMessageCallbackQueryImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        super(jsonObject, telegramBot);

        this.gameShortName = jsonObject.getString("game_short_name");
        this.message = MessageImpl.createMessage(jsonObject.optJSONObject("message"), telegramBot);
    }

    public static GameMessageCallbackQuery createGameCallbackQuery(JSONObject jsonObject, TelegramBot telegramBot) {


        return jsonObject != null ? new GameMessageMessageCallbackQueryImpl(jsonObject, telegramBot) : null;
    }

    @Override
    public String getGameShortName() {
        return gameShortName;
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
