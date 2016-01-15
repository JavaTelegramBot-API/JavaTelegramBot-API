package pro.zackpollard.telegrambot.api.event.chat.inline;

import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.inline.ChosenInlineResult;
import pro.zackpollard.telegrambot.api.event.Event;

/**
 * @author Zack Pollard
 */
@RequiredArgsConstructor
public class InlineResultChosenEvent implements Event {

    private final ChosenInlineResult chosenInlineResult;

    public ChosenInlineResult getChosenResult() {

        return chosenInlineResult;
    }
}