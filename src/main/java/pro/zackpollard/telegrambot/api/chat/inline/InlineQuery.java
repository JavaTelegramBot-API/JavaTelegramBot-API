package pro.zackpollard.telegrambot.api.chat.inline;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.inline.send.InlineQueryResponse;
import pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResult;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Location;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public interface InlineQuery {

    /**
     * Gets the ID of this inline query
     *
     * @return The ID of this inline query
     */
    String getQueryId();

    /**
     * Gets the User that sent this inline query
     *
     * @return The User that sent this inline query
     */
    User getSender();

    /**
     * Gets the Location of the User that sent this inline query
     *
     * @return The Location of the User that sent the query, or null if no Location was sent
     */
    Location getLocation();

    /**
     * Gets the query string that was sent by the User
     *
     * @return The query string that was sent by the user
     */
    String getQuery();

    /**
     * The offset for this query, this can be used to enable pagination when the user scrolls to the end of the
     * current list of results. When this happens, the API will provide an identical InlineQuery object with an offset
     * that was set in the previous inline query response. This makes it possible to return more results that are
     * different from the first set of results
     *
     * @return The offset for the current query
     */
    String getOffset();

    /**
     * Gets the JSONObject that was sent by the bot API to produce this object
     *
     * @return The JSONObject version of this object
     */
    JSONObject asJson();

    /**
     * This method allows you to directly answer the Inline Query from this object. If you provide a list of
     * InlineQueryResults then the response will be instantly sent back to the User
     *
     * @param telegramBot   The TelegramBot instance that is related to this query
     * @param results       An array of results to be sent back to the User
     *
     * @return True if the response was sent successfully, otherwise False
     */
    default boolean answer(TelegramBot telegramBot, InlineQueryResult... results) {

        return this.answer(telegramBot, InlineQueryResponse.builder().results(results).build());
    }

    /**
     * This method allows you to directly answer the Inline Query from this object. If you provide an
     * InlineQueryResponse object then the response will be instantly sent back to the User
     *
     * @param telegramBot   The TelegramBot instance that is related to this query
     * @param response      An InlineQueryResponse object containing the results to the inline query
     *
     * @return True if the response was sent successfully, otherwise False
     */
    default boolean answer(TelegramBot telegramBot, InlineQueryResponse response) {

        return telegramBot.answerInlineQuery(getQueryId(), response);
    }
}
