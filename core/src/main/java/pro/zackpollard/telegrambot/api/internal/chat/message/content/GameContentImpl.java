package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.AudioContent;
import pro.zackpollard.telegrambot.api.chat.message.content.GameContent;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Audio;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Game;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.AudioImpl;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.GameImpl;

/**
 * @author Zack Pollard
 */
public class GameContentImpl implements GameContent {

    private final Game content;

    private GameContentImpl(JSONObject jsonObject) {

        this.content = GameImpl.createGame(jsonObject);
    }

    public static GameContent createGameContent(JSONObject jsonObject) {

        return jsonObject != null ? new GameContentImpl(jsonObject) : null;
    }

    @Override
    public Game getContent() {

        return content;
    }
}
