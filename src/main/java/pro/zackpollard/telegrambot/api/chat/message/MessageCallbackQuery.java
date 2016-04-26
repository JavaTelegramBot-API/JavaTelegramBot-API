package pro.zackpollard.telegrambot.api.chat.message;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.chat.CallbackQueryType;

/**
 * @author zackp
 */
public interface MessageCallbackQuery extends CallbackQuery {

    Message getMessage();

    @Override
    default CallbackQueryType getType() {

        return CallbackQueryType.MESSAGE;
    }
}
