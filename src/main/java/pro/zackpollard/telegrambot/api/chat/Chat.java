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
import pro.zackpollard.telegrambot.api.internal.chat.ChatMemberImpl;
import pro.zackpollard.telegrambot.api.user.User;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static pro.zackpollard.telegrambot.api.utils.Utils.processResponse;

/**
 * @author Zack Pollard
 */
public interface Chat {

    String getId();

    String getName();

    ChatType getType();

    TelegramBot getBotInstance();

    Message sendMessage(SendableMessage message);

    default Message sendMessage(String message) {

        return this.sendMessage(SendableTextMessage.builder().message(message).build());
    }

    default Integer getChatMembersCount() {

        try {

            MultipartBody request = Unirest.post(getBotInstance().getBotAPIUrl() + "getChatMembersCount")
                    .field("chat_id", getId(), "application/json");
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

    default List<ChatMember> getChatAdministrators() {

        try {

            MultipartBody request = Unirest.post(getBotInstance().getBotAPIUrl() + "getChatAdministrators")
                    .field("chat_id", getId(), "application/json");
            HttpResponse<String> response = request.asString();
            JSONObject jsonResponse = processResponse(response);

            if (jsonResponse != null && Utils.checkResponseStatus(jsonResponse)) {

                JSONArray jsonArray = jsonResponse.getJSONArray("result");

                List<ChatMember> chatAdmins = new ArrayList<>();

                for(int i = 0; i < jsonArray.length(); ++i) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    chatAdmins.add(ChatMemberImpl.createChatMember(jsonObject));
                }

                return chatAdmins;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    default ChatMember getChatMember(User user) {

        return getChatMember(user.getId());
    }

    default ChatMember getChatMember(long userID) {

        try {

            MultipartBody request = Unirest.post(getBotInstance().getBotAPIUrl() + "getChatMember")
                    .field("chat_id", getId(), "application/json")
                    .field("user_id", userID);
            HttpResponse<String> response = request.asString();
            JSONObject jsonResponse = processResponse(response);

            if (jsonResponse != null && Utils.checkResponseStatus(jsonResponse)) {

                return ChatMemberImpl.createChatMember(jsonResponse.getJSONObject("result"));
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }
}