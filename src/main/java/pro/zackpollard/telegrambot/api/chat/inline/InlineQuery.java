package pro.zackpollard.telegrambot.api.chat.inline;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.inline.send.InlineQueryResponse;
import pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResult;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public interface InlineQuery {

    String getQueryId();

    User getSender();

    String getQuery();

    String getOffset();

    JSONObject asJson();

    default boolean answer(TelegramBot telegramBot, InlineQueryResult... results) {

        return this.answer(telegramBot, InlineQueryResponse.builder().results(results).build());
    }

    default boolean answer(TelegramBot telegramBot, InlineQueryResponse response) {

        return telegramBot.answerInlineQuery(getQueryId(), response);
    }
}
