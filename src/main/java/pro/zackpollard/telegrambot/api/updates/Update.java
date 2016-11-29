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

    /**
     * Gets the The update‘s unique identifier. Update identifiers start from a certain positive number and increase
     * sequentially.
     *
     * @return The ID of this Update
     */
    int getId();

    /**
     * Gets the Message that this Update contains. New incoming message of any kind — text, photo, sticker, etc
     *
     * @return New incoming message of any kind — text, photo, sticker, etc
     */
    Message getMessage();

    /**
     * Gets the Edited Message that this Update contains. New version of a message that is known to the bot and was
     * edited
     *
     * @return New version of a message that is known to the bot and was edited
     */
    Message getEditedMessage();

    /**
     * Gets the Channel Post Message that this Update contains.
     *
     * @return Channel Post message
     */
    Message getChannelPost();

    /**
     * Gets the new incoming inline query
     *
     * @return The new incoming inline query
     */
    InlineQuery getInlineQuery();

    /**
     * Gets the result of an inline query that was chosen by a user and sent to their chat partner
     *
     * @return The result of an inline query that was chosen by a user and sent to their chat partner
     */
    ChosenInlineResult getChosenInlineResult();

    /**
     * Gets the new incoming callback query
     *
     * @return The new incoming callback query
     */
    CallbackQuery getCallbackQuery();

    /**
     * Gets the UpdateType of this Update
     *
     * @return The UpdateType of this Update
     */
    UpdateType getType();

    /**
     * Gets the TelegramBot instance that is responsible for this Update
     *
     * @return The TelegramBot instance that is responsible for this Update
     */
    TelegramBot getBotInstance();

    enum UpdateType {

        MESSAGE,
        EDITED_MESSAGE,
        INLINE_QUERY,
        CALLBACK_QUERY,
        CHOSEN_INLINE_RESULT,
        CHANNEL_POST
    }
}
