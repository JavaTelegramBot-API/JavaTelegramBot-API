package pro.zackpollard.telegrambot.api.event.chat.game;

import pro.zackpollard.telegrambot.api.chat.inline.GameInlineCallbackQuery;
import pro.zackpollard.telegrambot.api.event.chat.CallbackQueryReceivedEvent;

/**
 * @author zackp
 */
public class GameInlineCallbackQueryReceivedEvent extends CallbackQueryReceivedEvent {

    public GameInlineCallbackQueryReceivedEvent(GameInlineCallbackQuery gameCallbackQuery) {

        super(gameCallbackQuery);
    }

    /**
     * Gets the GameInlineCallbackQuery object that fired this Event
     *
     * @return The GameInlineCallbackQuery that fired this Event
     */
    public GameInlineCallbackQuery getCallbackQuery() {

        return (GameInlineCallbackQuery) callbackQuery;
    }
}