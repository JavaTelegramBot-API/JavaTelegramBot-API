package pro.zackpollard.telegrambot.api.internal.chat.game;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.inline.GameInlineCallbackQuery;
import pro.zackpollard.telegrambot.api.internal.chat.inline.InlineCallbackQueryImpl;

/**
 * @author zackp
 */
public class InlineGameCallbackQueryImpl extends InlineCallbackQueryImpl implements GameInlineCallbackQuery {

    private final String game_short_name;

    private InlineGameCallbackQueryImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        super(jsonObject, telegramBot);

        this.game_short_name = jsonObject.getString("game_short_name");
    }

    public static GameInlineCallbackQuery createGameCallbackQuery(JSONObject jsonObject, TelegramBot telegramBot) {

        return jsonObject != null ? new InlineGameCallbackQueryImpl(jsonObject, telegramBot) : null;
    }

    @Override
    public String getGameShortName() {
        return game_short_name;
    }
}
