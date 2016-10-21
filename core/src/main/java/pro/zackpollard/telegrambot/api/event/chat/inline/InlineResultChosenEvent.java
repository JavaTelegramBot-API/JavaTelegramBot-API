package pro.zackpollard.telegrambot.api.event.chat.inline;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.ChosenInlineResult;
import pro.zackpollard.telegrambot.api.event.Cancellable;
import pro.zackpollard.telegrambot.api.event.Event;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor
public class InlineResultChosenEvent implements Event, Cancellable {

    private final ChosenInlineResult chosenInlineResult;

    @Getter
    @Setter
    private boolean cancelled;

    /**
     * Gets the ChosenInlineResult that fired this Event
     *
     * @return The ChosenInlineResult that fired this Event
     */
    public ChosenInlineResult getChosenResult() {

        return chosenInlineResult;
    }
}