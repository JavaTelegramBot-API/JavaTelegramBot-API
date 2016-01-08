package pro.zackpollard.telegrambot.api.updates;

import pro.zackpollard.telegrambot.api.chat.inline.ChosenInlineResult;
import pro.zackpollard.telegrambot.api.chat.inline.InlineQuery;
import pro.zackpollard.telegrambot.api.chat.message.Message;

/**
 * @author Zack Pollard
 */
public interface Update {

	int getId();

	Message getMessage();
    InlineQuery getInlineQuery();
    ChosenInlineResult getChosenInlineResult();

    UpdateType getType();

    enum UpdateType {

        MESSAGE,
        INLINE_QUERY,
        CHOSEN_INLINE_RESULT
    }
}
