package pro.zackpollard.telegrambot.api.chat.message;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.chat.CallbackQueryType;
import pro.zackpollard.telegrambot.api.chat.inline.InlineCallbackQuery;

/**
 * @author zackp
 */
public interface GameMessageCallbackQuery extends CallbackQuery {

    /**
     * Gets the short name of the game that this callback query relates to
     *
     * @return The short name of the game
     */
    String getGameShortName();

    /**
     * Gets the Message object associated with the GameMessageCallbackQuery
     *
     * @return The Message associated with the GameMessageCallbackQuery
     */
    Message getMessage();

    /**
     * Gets the CallbackQueryType for this callback query
     *
     * @return The CallbackQueryType for this callback query
     */
    @Override
    default CallbackQueryType getType() {

        return CallbackQueryType.MESSAGE_GAME;
    }
}