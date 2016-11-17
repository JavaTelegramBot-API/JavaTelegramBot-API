package pro.zackpollard.telegrambot.api.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.request.body.MultipartBody;
import org.json.JSONException;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.ForceReply;
import pro.zackpollard.telegrambot.api.chat.message.send.NotificationOptions;
import pro.zackpollard.telegrambot.api.chat.message.send.ReplyingOptions;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardMarkup;
import pro.zackpollard.telegrambot.api.keyboards.ReplyKeyboardHide;
import pro.zackpollard.telegrambot.api.keyboards.ReplyKeyboardMarkup;
import pro.zackpollard.telegrambot.api.keyboards.ReplyKeyboardRemove;

import java.util.Random;

/**
 * @author Zack Pollard
 */
public class Utils {

    /**
     * Generates a random alphanumeric String of the length specified
     *
     * @param length The required length of the String
     *
     * @return A random alphanumeric String
     */
    public static String generateRandomString(int length) {

        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString();
    }

    /**
     * This does some generic processing on HttpResponse objects returned by the Telegram Bot API
     *
     * @param response The HttpResponse object returned by Unirest from the Telegram Bot API call
     *
     * @return A JSONObject containing the processed response or null if something was wrong with the response
     */
    public static JSONObject processResponse(HttpResponse<String> response) {

        if (response != null) {

            if (response.getStatus() == 200) {

                try {

                    return new JSONObject(response.getBody());
                } catch (JSONException e) {

                    System.err.println("The API didn't return a JSON response. The actual response was " + response.getBody());
                }
            } else {

                JSONObject jsonResponse = null;

                try {

                    jsonResponse = new JSONObject(response.getBody());
                } catch (JSONException e) {
                }

                if (jsonResponse != null) {

                    System.err.println("The API returned the following error: " + jsonResponse.getString("description"));
                } else {

                    System.err.println("The API returned error code " + response.getStatus());
                }
            }
        }

        return null;
    }

    /**
     * This does generic processing of ReplyingOptions objects when sending a request to the API
     *
     * @param multipartBody     The MultipartBody that the ReplyingOptions content should be appended to
     * @param replyingOptions   The ReplyingOptions that were used in this request
     */
    public static void processReplyContent(MultipartBody multipartBody, ReplyingOptions replyingOptions) {

        if (replyingOptions.getReplyTo() != 0)
            multipartBody.field("reply_to_message_id", String.valueOf(replyingOptions.getReplyTo()), "application/json; charset=utf8;");
        if (replyingOptions.getReplyMarkup() != null) {

            switch (replyingOptions.getReplyMarkup().getType()) {

                case FORCE_REPLY:
                    multipartBody.field("reply_markup", TelegramBot.GSON.toJson(replyingOptions.getReplyMarkup(), ForceReply.class), "application/json; charset=utf8;");
                    break;
                case KEYBOARD_HIDE:
                    multipartBody.field("reply_markup", TelegramBot.GSON.toJson(replyingOptions.getReplyMarkup(), ReplyKeyboardHide.class), "application/json; charset=utf8;");
                    break;
                case KEYBOARD_REMOVE:
                    multipartBody.field("reply_markup", TelegramBot.GSON.toJson(replyingOptions.getReplyMarkup(), ReplyKeyboardRemove.class), "application/json; charset=utf8;");
                    break;
                case KEYBOARD_MARKUP:
                    multipartBody.field("reply_markup", TelegramBot.GSON.toJson(replyingOptions.getReplyMarkup(), ReplyKeyboardMarkup.class), "application/json; charset=utf8;");
                    break;
                case INLINE_KEYBOARD_MARKUP:
                    multipartBody.field("reply_markup", TelegramBot.GSON.toJson(replyingOptions.getReplyMarkup(), InlineKeyboardMarkup.class), "application/json; charset=utf8;");
                    break;
            }
        }
    }

    /**
     * This does generic processing of NotificationOptions objects when sending a request to the API
     *
     * @param multipartBody         The MultipartBody that the NotificationOptions content should be appended to
     * @param notificationOptions   The NotificationOptions that were used in this request
     */
    public static void processNotificationContent(MultipartBody multipartBody, NotificationOptions notificationOptions) {

        multipartBody.field("disable_notification", notificationOptions.isDisableNotification());
    }

    /**
     * This does generic processing of processed JSON objects to ensure that the API returned ok: true
     *
     * @param jsonResponse The JSONObject that you want to check
     *
     * @return True if the JSONObject contained ok: true, otherwise False
     */
    public static boolean checkResponseStatus(JSONObject jsonResponse) {

        if (jsonResponse != null) {

            if (jsonResponse.getBoolean("ok")) {

                return true;
            } else {

                System.err.println("The API returned the following error: " + jsonResponse.getString("description"));
            }
        } else {

            System.err.println("JSON Response was null, something went wrong...");
        }

        return false;
    }

    /**
     * Generic method for ensuring an object isn't null, if it is null a NullPointerException is thrown
     *
     * @param object The object you want to check isn't null
     */
    public static void validateNotNull(Object object) {
        validateNotNull(object, "");
    }

    /**
     * Generic method for ensuring an object isn't null, if it is null a NullPointerException is thrown
     *
     * @param object    The object you want to check isn't null
     * @param message   The message you want the NullPointerException to have in the case that the object is null
     */
    public static void validateNotNull(Object object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }

    /**
     * Generic method for ensuring an array of objects aren't null, if any object is null a NullPointerException is
     * thrown
     *
     * @param objects The objects that you want to ensure aren't null
     */
    public static void validateNotNull(Object... objects) {
        for (Object o : objects) {
            validateNotNull(o);
        }
    }
}