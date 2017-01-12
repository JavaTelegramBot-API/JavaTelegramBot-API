package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Game;
import pro.zackpollard.telegrambot.api.chat.message.content.type.MessageEntity;

import java.util.List;

/**
 * @author Zack Pollard
 */
public interface GameContent extends Content {

    /**
     * Gets the String object relating to this GameContent object
     *
     * @return The Game object
     */
    Game getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.GAME;
    }
}
