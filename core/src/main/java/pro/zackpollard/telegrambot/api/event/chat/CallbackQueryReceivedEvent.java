package pro.zackpollard.telegrambot.api.event.chat;

import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.event.Cancellable;
import pro.zackpollard.telegrambot.api.event.Event;

/**
 * @author zackp
 */
@ToString
public class CallbackQueryReceivedEvent implements Event, Cancellable{

    protected final CallbackQuery callbackQuery;

    private boolean cancelled;

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

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }
}
