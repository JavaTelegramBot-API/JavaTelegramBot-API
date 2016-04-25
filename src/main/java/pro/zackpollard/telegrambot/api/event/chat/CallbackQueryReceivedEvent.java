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

    public CallbackQuery getCallbackQuery() {

        return callbackQuery;
    }
}
