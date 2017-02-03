package pro.zackpollard.telegrambot.api.internal.chat.inline;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.inline.GameInlineCallbackQuery;
import pro.zackpollard.telegrambot.api.chat.inline.InlineCallbackQuery;
import pro.zackpollard.telegrambot.api.internal.chat.CallbackQueryImpl;

/**
 * @author zackp
 */
public class GameInlineCallbackQueryImpl extends CallbackQueryImpl implements GameInlineCallbackQuery {

    private final String inline_message_id;
    private final String game_short_name;

    protected GameInlineCallbackQueryImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        super(jsonObject, telegramBot);

        this.inline_message_id = jsonObject.getString("inline_message_id");
        this.game_short_name = jsonObject.getString("game_short_name");
    }

    public static GameInlineCallbackQuery createGameInlineCallbackQuery(JSONObject jsonObject, TelegramBot telegramBot) {

        return jsonObject != null ? new GameInlineCallbackQueryImpl(jsonObject, telegramBot) : null;
    }

    @Override
    public String getInlineMessageId() {
        return inline_message_id;
    }

    @Override
    public String getGameShortName() {
        return game_short_name;
    }
}
