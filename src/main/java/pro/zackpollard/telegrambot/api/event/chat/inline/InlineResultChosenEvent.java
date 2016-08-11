package pro.zackpollard.telegrambot.api.event.chat.inline;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.ChosenInlineResult;
import pro.zackpollard.telegrambot.api.event.Event;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor
public class InlineResultChosenEvent implements Event {

    private final ChosenInlineResult chosenInlineResult;

    /**
     * Gets the ChosenInlineResult that fired this Event
     *
     * @return The ChosenInlineResult that fired this Event
     */
    public ChosenInlineResult getChosenResult() {

        return chosenInlineResult;
    }
}