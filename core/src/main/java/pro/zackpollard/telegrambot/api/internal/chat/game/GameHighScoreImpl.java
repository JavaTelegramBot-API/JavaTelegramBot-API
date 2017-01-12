package pro.zackpollard.telegrambot.api.internal.chat.game;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.games.GameHighScore;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author zackp
 */
public class GameHighScoreImpl implements GameHighScore {

    private final long position;
    private final User user;
    private final long score;

    private GameHighScoreImpl(JSONObject jsonObject) {

        this.position = jsonObject.getLong("position");
        this.user = UserImpl.createUser(jsonObject.getJSONObject("user"));
        this.score = jsonObject.getLong("score");
    }

    public static GameHighScore createGameHighscore(JSONObject jsonObject) {

        return jsonObject != null ? new GameHighScoreImpl(jsonObject) : null;
    }

    @Override
    public long getPosition() {
        return position;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public long getScore() {
        return score;
    }
}
