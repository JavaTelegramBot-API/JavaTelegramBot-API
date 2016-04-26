package pro.zackpollard.telegrambot.api.chat.inline;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.chat.CallbackQueryType;

/**
 * @author zackp
 */
public interface InlineCallbackQuery extends CallbackQuery {

    String getInlineMessageId();

    @Override
    default CallbackQueryType getType() {

        return CallbackQueryType.INLINE_MESSAGE;
    }
}
