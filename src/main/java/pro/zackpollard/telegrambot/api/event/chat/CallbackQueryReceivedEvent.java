package pro.zackpollard.telegrambot.api.event.chat;

import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.event.Event;

/**
 * @author zackp
 */
@ToString
public class CallbackQueryReceivedEvent implements Event {

    protected final CallbackQuery callbackQuery;

    public CallbackQueryReceivedEvent(CallbackQuery callbackQuery) {

        this.callbackQuery = callbackQuery;
    }

    /**
     * Gets the CallbackQuery that was received that triggered this Event
     *
     * @return The CallbackQuery that was received that triggered this Event
     */
    public CallbackQuery getCallbackQuery() {

        return callbackQuery;
    }
}
