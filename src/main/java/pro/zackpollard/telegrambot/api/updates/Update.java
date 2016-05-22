package pro.zackpollard.telegrambot.api.updates;

import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.chat.inline.ChosenInlineResult;
import pro.zackpollard.telegrambot.api.chat.inline.InlineQuery;
import pro.zackpollard.telegrambot.api.chat.message.Message;

/**
 * @author Zack Pollard
 */
public interface Update {

    int getId();

    Message getMessage();

    Message getEditedMessage();

    InlineQuery getInlineQuery();

    ChosenInlineResult getChosenInlineResult();

    CallbackQuery getCallbackQuery();

    UpdateType getType();

    TelegramBot getBotInstance();

    enum UpdateType {

        MESSAGE,
        EDITED_MESSAGE,
        INLINE_QUERY,
        CALLBACK_QUERY,
        CHOSEN_INLINE_RESULT
    }
}
