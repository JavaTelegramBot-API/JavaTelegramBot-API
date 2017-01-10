package pro.zackpollard.telegrambot.api.internal.chat.game;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.games.GameHighScore;
import pro.zackpollard.telegrambot.api.games.GameScoreEditResponse;
import pro.zackpollard.telegrambot.api.internal.chat.message.MessageImpl;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author zackp
 */
public class GameScoreEditResponseImpl implements GameScoreEditResponse {

    private final Message message;
    private final boolean response;

    private GameScoreEditResponseImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.message = MessageImpl.createMessage(jsonObject.optJSONObject("result"), telegramBot);
        this.response = message != null || jsonObject.getBoolean("result");
    }

    public static GameScoreEditResponse createGameScoreEditResponse(JSONObject jsonObject, TelegramBot telegramBot) {

        return jsonObject != null ? new GameScoreEditResponseImpl(jsonObject, telegramBot) : null;
    }

    @Override
    public Message getMessage() {
        return message;
    }

    @Override
    public boolean getResponse() {
        return response;
    }
}
