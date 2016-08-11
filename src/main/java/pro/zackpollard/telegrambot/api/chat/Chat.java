package pro.zackpollard.telegrambot.api.chat;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.body.MultipartBody;
import org.json.JSONArray;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableTextMessage;
import pro.zackpollard.telegrambot.api.user.User;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static pro.zackpollard.telegrambot.api.internal.chat.ChatMemberImpl.createChatMember;
import static pro.zackpollard.telegrambot.api.utils.Utils.processResponse;


/**
 * @author Zack Pollard
 */
public interface Chat {

    /**
     * Gets the ID of this Chat
     *
     * @return The ID of this Chat
     */
    String getId();

    /**
     * Gets the name of the Chat
     *
     * @return The name of the Chat
     */
    String getName();

    /**
     * Gets the ChatType of this Chat
     *
     * @return The ChatType of this Chat
     */
    ChatType getType();

    /**
     * Gets the TelegramBot instance associated with this Chat object
     *
     * @return The TelegramBot instance associated with this Chat object
     */
    TelegramBot getBotInstance();

    /**
     * Send any type of SendableMessage to this Chat
     *
     * @param message The SendableMessage you want to send to the Chat
     *
     * @return The Message object associated with the sent message, or null if sending failed
     */
    Message sendMessage(SendableMessage message);

    /**
     * Send a String message to this Chat
     *
     * @param message The String message you want to send to the chat
     *
     * @return The Message object associated with the sent message, or null if sending failed
     */
    default Message sendMessage(String message) {

        return this.sendMessage(SendableTextMessage.builder().message(message).build());
    }

    /**
     * Gets the amount of people in the chat
     *
     * @return The amount of people in the chat
     */
    default Integer getChatMembersCount() {

        try {

            MultipartBody request = Unirest.post(getBotInstance().getBotAPIUrl() + "getChatMembersCount")
                    .field("chat_id", getId(), "application/json; charset=utf8;");
            HttpResponse<String> response = request.asString();
            JSONObject jsonResponse = processResponse(response);

            if (jsonResponse != null && Utils.checkResponseStatus(jsonResponse)) {

                return jsonResponse.getInt("result");
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Gets a List of ChatMember objects for all the people who are admin in the chat
     *
     * @return A List of ChatMember objects for all the people who are admin in the chat
     */
    default List<ChatMember> getChatAdministrators() {

        try {

            MultipartBody request = Unirest.post(getBotInstance().getBotAPIUrl() + "getChatAdministrators")
                    .field("chat_id", getId(), "application/json; charset=utf8;");
            HttpResponse<String> response = request.asString();
            JSONObject jsonResponse = processResponse(response);

            if (jsonResponse != null && Utils.checkResponseStatus(jsonResponse)) {

                JSONArray jsonArray = jsonResponse.getJSONArray("result");

                List<ChatMember> chatAdmins = new ArrayList<>();

                for(int i = 0; i < jsonArray.length(); ++i) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    chatAdmins.add(createChatMember(jsonObject));
                }

                return chatAdmins;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Gets the ChatMember object for a specific User in respect to this chat
     *
     * @param user The User that you want the ChatMember object for
     *
     * @return The ChatMember object for this user or Null if the request failed
     */
    default ChatMember getChatMember(User user) {

        return getChatMember(user.getId());
    }

    /**
     * Gets the ChatMember object for a specific user based on their ID in respect to this chat
     *
     * @param userID The ID of the user that you want the ChatMember object for
     *
     * @return The ChatMember object for this user or Null if the request failed
     */
    default ChatMember getChatMember(long userID) {

        try {

            MultipartBody request = Unirest.post(getBotInstance().getBotAPIUrl() + "getChatMember")
                    .field("chat_id", getId(), "application/json; charset=utf8;")
                    .field("user_id", userID);
            HttpResponse<String> response = request.asString();
            JSONObject jsonResponse = processResponse(response);

            if (jsonResponse != null && Utils.checkResponseStatus(jsonResponse)) {

                return createChatMember(jsonResponse.getJSONObject("result"));
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * If you call this method then the bot will leave this Chat if it is currently in it
     *
     * @return True if leaving the chat succeeded, otherwise False
     */
    default boolean leaveChat() {

        try {

            MultipartBody request = Unirest.post(getBotInstance().getBotAPIUrl() + "leaveChat")
                    .field("chat_id", getId(), "application/json; charset=utf8;");
            HttpResponse<String> response = request.asString();
            JSONObject jsonResponse = processResponse(response);

            if (jsonResponse != null && Utils.checkResponseStatus(jsonResponse)) {

                return jsonResponse.getBoolean("result");
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }
}