package pro.zackpollard.telegrambot.api.event.chat.inline;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.InlineQuery;
import pro.zackpollard.telegrambot.api.event.Event;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor
public class InlineQueryReceivedEvent implements Event {

    private final InlineQuery inlineQuery;

    public InlineQuery getQuery() {

        return inlineQuery;
    }
}