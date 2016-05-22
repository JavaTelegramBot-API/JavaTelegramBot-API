package pro.zackpollard.telegrambot.api.chat.inline;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.inline.send.InlineQueryResponse;
import pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResult;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Location;
import pro.zackpollard.telegrambot.api.exception.TelegramApiException;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public interface InlineQuery {

    String getQueryId();

    User getSender();

    Location getLocation();

    String getQuery();

    String getOffset();

    JSONObject asJson();

    default boolean answer(TelegramBot telegramBot, InlineQueryResult... results) throws TelegramApiException {

        return this.answer(telegramBot, InlineQueryResponse.builder().results(results).build());
    }

    default boolean answer(TelegramBot telegramBot, InlineQueryResponse response) throws TelegramApiException {

        return telegramBot.answerInlineQuery(getQueryId(), response);
    }
}
