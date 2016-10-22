package pro.zackpollard.telegrambot.api.chat.message;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.chat.CallbackQueryType;

/**
 * @author zackp
 */
public interface MessageCallbackQuery extends CallbackQuery {

    /**
     * Gets the Message object associated with the MessageCallbackQuery
     *
     * @return The Message associated with the MessageCallbackQuery
     */
    Message getMessage();

    /**
     * Gets the CallbackQueryType for this callback query
     *
     * @return The CallbackQueryType for this callback query
     */
    @Override
    default CallbackQueryType getType() {

        return CallbackQueryType.MESSAGE;
    }
}
