package pro.zackpollard.telegrambot.api.event.chat.inline;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.InlineQuery;
import pro.zackpollard.telegrambot.api.event.Cancellable;
import pro.zackpollard.telegrambot.api.event.Event;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor
public class InlineQueryReceivedEvent implements Event, Cancellable {

    private final InlineQuery inlineQuery;

    @Getter
    @Setter
    private boolean cancelled;

    /**
     * Gets the InlineQuery that fired this Event
     *
     * @return The InlineQuery that fired this Event
     */
    public InlineQuery getQuery() {

        return inlineQuery;
    }
}