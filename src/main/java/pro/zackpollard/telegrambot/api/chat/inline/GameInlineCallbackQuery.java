package pro.zackpollard.telegrambot.api.chat.inline;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.chat.CallbackQueryType;

/**
 * @author zackp
 */
public interface GameInlineCallbackQuery extends CallbackQuery {

    /**
     * Gets the short name of the game that this callback query relates to
     *
     * @return The short name of the game
     */
    String getGameShortName();

    /**
     * Gets the ID of the inline message that this callback query relates to
     *
     * @return The ID of the inline message
     */
    String getInlineMessageId();

    /**
     * Gets the CallbackQueryType for this callback query
     *
     * @return The CallbackQueryType for this callback query
     */
    @Override
    default CallbackQueryType getType() {

        return CallbackQueryType.INLINE_GAME;
    }
}
