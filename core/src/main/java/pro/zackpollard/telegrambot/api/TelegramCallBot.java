package pro.zackpollard.telegrambot.api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.body.MultipartBody;
import lombok.Getter;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.inline.send.InlineQueryResponse;
import pro.zackpollard.telegrambot.api.chat.message.send.CallbackQueryResponse;
import pro.zackpollard.telegrambot.api.utils.Utils;

import static pro.zackpollard.telegrambot.api.TelegramBot.GSON;

public class TelegramCallBot {

    public static final String API_URL = "https://api.telegram.org/";

    private final String authToken = TelegramBot.authToken;

    public String getBotAPIUrl = TelegramBot.getBotAPIUrl();

    /**
     * This allows you to respond to an inline query with an InlineQueryResponse object
     *
     * @param inlineQueryId         The ID of the inline query you are responding to
     * @param inlineQueryResponse   The InlineQueryResponse object that you want to send to the user
     *
     * @return True if the response was sent successfully, otherwise False
     */
    public boolean answerInlineQuery(String inlineQueryId, InlineQueryResponse inlineQueryResponse) {

        if (inlineQueryId != null && inlineQueryResponse != null) {

            HttpResponse<String> response;
            JSONObject jsonResponse;

            try {
                MultipartBody requests = Unirest.post(getBotAPIUrl + "answerInlineQuery")
                        .field("inline_query_id", inlineQueryId)
                        .field("results", GSON.toJson(inlineQueryResponse.getResults()))
                        .field("cache_time", inlineQueryResponse.getCacheTime())
                        .field("is_personal", inlineQueryResponse.isPersonal())
                        .field("next_offset", inlineQueryResponse.getNextOffset())
                        .field("switch_pm_text", inlineQueryResponse.getSwitchPmText())
                        .field("switch_pm_parameter", inlineQueryResponse.getSwitchPmParameter());

                response = requests.asString();
                jsonResponse = Utils.processResponse(response);

                if (jsonResponse != null) {

                    if (jsonResponse.getBoolean("result")) return true;
                }
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * This allows you to respond to a callback query with some text as a response. This will either show up as an
     * alert or as a toast on the telegram client
     *
     * @param callbackQueryId   The ID of the callback query you are responding to
     * @param text              The text you would like to respond with
     * @param showAlert         True will show the text as an alert, false will show it as a toast notification
     *
     * @deprecated  This method is deprecated in favour of the {@link #answerCallbackQuery(String, CallbackQueryResponse)}
     *              method, this should be used for all new implementations
     *
     * @return True if the response was sent successfully, otherwise False
     */
    @Deprecated
    public boolean answerCallbackQuery(String callbackQueryId, String text, boolean showAlert) {

        return this.answerCallbackQuery(callbackQueryId, CallbackQueryResponse.builder().text(text).showAlert(showAlert).build());
    }

    /**
     * This allows you to respond to a callback query with some text as a response. This will either show up as an
     * alert or as a toast on the telegram client
     *
     * @param callbackQueryId       The ID of the callback query you are responding to
     * @param callbackQueryResponse The response that you would like to send in reply to this callback query
     *
     * @return True if the response was sent successfully, otherwise False
     */
    public boolean answerCallbackQuery(String callbackQueryId, CallbackQueryResponse callbackQueryResponse) {

        if(callbackQueryId != null && callbackQueryResponse.getText() != null) {

            HttpResponse<String> response;
            JSONObject jsonResponse;


            try {
                MultipartBody requests = Unirest.post(getBotAPIUrl + "answerCallbackQuery")
                        .field("callback_query_id", callbackQueryId, "application/json; charset=utf8;")
                        .field("text", callbackQueryResponse.getText(), "application/json; charset=utf8;")
                        .field("show_alert", callbackQueryResponse.isShowAlert())
                        .field("cache_time", callbackQueryResponse.getCacheTime())
                        .field("url", callbackQueryResponse.getURL() != null ? callbackQueryResponse.getURL().toExternalForm() : null, "application/json; charset=utf8;");


                response = requests.asString();
                jsonResponse = Utils.processResponse(response);

                if (jsonResponse != null) {

                    if (jsonResponse.getBoolean("result")) return true;
                }
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}

