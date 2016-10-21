package pro.zackpollard.telegrambot.api.chat.inline.send.results;

/**
 * @author Zack Pollard
 */
public interface InlineQueryResult {

    /**
     * Get the type of InlineQueryResult that this object refers to
     *
     * @return The InlineQueryResultType for this object
     */
    InlineQueryResultType getType();
}
