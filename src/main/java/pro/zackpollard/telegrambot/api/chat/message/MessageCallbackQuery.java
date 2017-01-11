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
     * Gets the data that was originally sent with the button used to trigger this InlineCallbackQuery
     *
     * @return The data that was original sent with the button used to trigger this InlineCallbackQuery
     */
    String getData();

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
