package pro.zackpollard.telegrambot.api.event.chat.game;

import pro.zackpollard.telegrambot.api.chat.inline.GameInlineCallbackQuery;
import pro.zackpollard.telegrambot.api.chat.message.GameMessageCallbackQuery;
import pro.zackpollard.telegrambot.api.event.chat.CallbackQueryReceivedEvent;

/**
 * @author zackp
 */
public class GameMessageCallbackQueryReceivedEvent extends CallbackQueryReceivedEvent {

    public GameMessageCallbackQueryReceivedEvent(GameMessageCallbackQuery gameCallbackQuery) {

        super(gameCallbackQuery);
    }

    /**
     * Gets the GameMessageCallbackQuery object that fired this Event
     *
     * @return The GameMessageCallbackQuery that fired this Event
     */
    public GameMessageCallbackQuery getCallbackQuery() {

        return (GameMessageCallbackQuery) callbackQuery;
    }
}
