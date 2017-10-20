package pro.zackpollard.telegrambot.api.chat;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.body.MultipartBody;
import org.json.JSONArray;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.InputFile;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableTextMessage;
import pro.zackpollard.telegrambot.api.user.User;
import pro.zackpollard.telegrambot.api.user.UserPromotions;
import pro.zackpollard.telegrambot.api.user.UserRestrictions;
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
     * The Chat Photo. Only returned when the object was returned from a call to getChat()
     *
     * @return A ChatPhoto object representing the photo for this chat
     */
    ChatPhoto getPhoto();

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

    /**
     * Use this method to kick a user from a group or a supergroup. In the case of supergroups, the user will not be
     * able to return to the group on their own using invite links, etc., unless unbanned first. The bot must be
     * an administrator in the group for this to work
     *
     * @param instance      The TelegramBot instance that you are using to call this method
     * @param chatId        The ID of the chat that you want to kick the user from
     * @param userId        The ID of the user that you want to kick from the chat
     * @param until_date    Date when the user will be unbanned, unix time. If user is banned for more than 366 days or
     *                      less than 30 seconds from the current time they are considered to be banned forever
     *
     * @return True if the user was kicked successfully, otherwise False
     */
    static boolean kickChatMember(TelegramBot instance, String chatId, int userId, long until_date) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "kickChatMember")
                    .field("chat_id", chatId, "application/json; charset=utf8;")
                    .field("user_id", userId)
                    .field("until_date", until_date);

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to unban a previously kicked user in a supergroup. The user will not return to the group
     * automatically, but will be able to join via link, etc. The bot must be an administrator in the group for
     * this to work
     *
     * @param instance  The TelegramBot instance that you are using to call this method
     * @param chatId    The ID of the chat that you want to unban the user from
     * @param userId    The ID of the user that you want to unban from the chat
     *
     * @return True if the user was unbanned, otherwise False
     */
    static boolean unbanChatMember(TelegramBot instance, String chatId, int userId) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "unbanChatMember")
                    .field("chat_id", chatId, "application/json; charset=utf8;")
                    .field("user_id", userId);

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this
     * to work and must have the appropriate admin rights. Pass True for all boolean parameters to lift restrictions
     * from a user
     *
     * @param instance          The TelegramBot instance that you are using to call this method
     * @param chatId            The ID of the chat that you want to restrict the user in
     * @param userId            The ID of the user that you want to restrict
     * @param userRestrictions  The UserRestrictions object containing the restrictions you want to place on the user
     *
     * @return Returns True if the restrictions were applied successfully, False otherwise
     */
    static boolean restrictChatMember(TelegramBot instance, String chatId, int userId, UserRestrictions userRestrictions) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post( instance.getBotAPIUrl() + "restrictChatMember")
                    .field("chat_id", chatId, "application/json; charset=utf8;")
                    .field("user_id", userId)
                    .field("until_date", userRestrictions.getUntilDate())
                    .field("can_send_messages", userRestrictions.getCanSendMessages())
                    .field("can_send_media_messages", userRestrictions.getCanSendMediaMessages())
                    .field("can_send_other_messages", userRestrictions.getCanSendOtherMessages())
                    .field("can_add_web_page_previews", userRestrictions.getCanAddWebPagePreviews());

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the
     * chat for this to work and must have the appropriate admin rights. Pass False for all boolean parameters to demote
     * a user
     *
     * @param instance          The TelegramBot instance that you are using to call this method
     * @param chatId            The ID of the chat that you want to promote the user in
     * @param userId            The ID of the user that you want to promote
     * @param userPromotions    The UserPromotions object containing the promotions you want to place on the user
     *
     * @return Returns True if the promotions were applied successfully, False otherwise
     */
    static boolean promoteChatMember(TelegramBot instance, String chatId, int userId, UserPromotions userPromotions) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "promoteChatMember")
                    .field("chat_id", chatId, "application/json; charset=utf8;")
                    .field("user_id", userId)
                    .field("can_change_info", userPromotions.getCanChangeInfo())
                    .field("can_post_messages", userPromotions.getCanPostMessages())
                    .field("can_edit_messages", userPromotions.getCanEditMessages())
                    .field("can_delete_messages", userPromotions.getCanDeleteMessages())
                    .field("can_invite_users", userPromotions.getCanInviteUsers())
                    .field("can_restrict_members", userPromotions.getCanRestrictMembers())
                    .field("can_pin_messages", userPromotions.getCanPinMessages())
                    .field("can_promote_members", userPromotions.getCanPromoteMembers());

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to export an invite link to a supergroup or a channel. The bot must be an administrator in the
     * chat for this to work and must have the appropriate admin rights
     *
     * @param instance  The TelegramBot instance that you are using to call this method
     * @param chatId    The id of the chat that you would like to export the invite link for
     *
     * @return The invite link for the chat, or null if the export failed
     */
    static String exportChatInviteLink(TelegramBot instance, String chatId) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "exportChatInviteLink")
                    .field("chat_id", chatId, "application/json; charset=utf8;");

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                return jsonResponse.getString("result");
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must
     * be an administrator in the chat for this to work and must have the appropriate admin rights
     *
     * @param instance      The TelegramBot instance that you are using to call this method
     * @param chatId        The ID of the chat that you want to set the photo for
     * @param inputFile     The InputFile form of the Photo that you would like to set as the chat photo
     *
     * @return Returns True if the chat image was set successfully, False otherwise
     */
    static boolean setChatPhoto(TelegramBot instance, String chatId, InputFile inputFile) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "setChatPhoto")
                    .field("chat_id", chatId, "application/json; charset=utf8;");

            Utils.processInputFileField(request, "photo", inputFile);

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an
     * administrator in the chat for this to work and must have the appropriate admin rights
     *
     * @param instance      The TelegramBot instance that you are using to call this method
     * @param chatId        The ID of the chat that you want to delete the photo for
     *
     * @return Returns True if the chat image was deleted successfully, False otherwise
     */
    static boolean deleteChatPhoto(TelegramBot instance, String chatId) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "deleteChatPhoto")
                    .field("chat_id", chatId, "application/json; charset=utf8;");

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an
     * administrator in the chat for this to work and must have the appropriate admin rights
     *
     * @param instance  The TelegramBot instance that you are using to call this method
     * @param chatId    The ID of the chat that you want to set the title for
     * @param title     The title that you would like to be set for the chat
     *
     * @return Returns True if the title was set successfully, False otherwise
     */
    static boolean setChatTitle(TelegramBot instance, String chatId, String title) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "setChatTitle")
                    .field("chat_id", chatId, "application/json; charset=utf8;")
                    .field("title", title, "application/json; charset=utf8");

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to change the description of a supergroup or a channel. The bot must be an administrator in the
     * chat for this to work and must have the appropriate admin rights
     *
     * @param instance      The TelegramBot instance that you are using to call this method
     * @param chatId        The ID of the chat that you want to set the description for
     * @param description   The description that you would like to be set for the chat
     *
     * @return Returns True if the description was set successfully, False otherwise
     */
    static boolean setChatDescription(TelegramBot instance, String chatId, String description) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "setChatDescription")
                    .field("chat_id", chatId, "application/json; charset=utf8;")
                    .field("description", description, "application/json; charset=utf8");

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to pin a message in a supergroup. The bot must be an administrator in the chat for this to work
     * and must have the appropriate admin rights
     *
     * @param instance              The TelegramBot instance that you are using to call this method
     * @param chatId                The ID of the chat that you want to set the pinned message for
     * @param messageId             The ID of the message that you want to pin
     * @param disableNotification   True if you want to disable all users being notified about the new pinned message
     *
     * @return Returns True if the pinned message was set successfully, False otherwise
     */
    static boolean pinChatMessage(TelegramBot instance, String chatId, long messageId, boolean disableNotification) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "pinChatMessage")
                    .field("chat_id", chatId, "application/json; charset=utf8;")
                    .field("message_id", messageId)
                    .field("disable_notification", disableNotification);

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to unpin a message in a supergroup chat. The bot must be an administrator in the chat for this to
     * work and must have the appropriate admin rights
     *
     * @param instance  The TelegramBot instance that you are using to call this method
     * @param chatId    The ID of the chat that you want to set the pinned message for
     *
     * @return Returns True if the pinned message was set successfully, False otherwise
     */
    static boolean unpinChatMessage(TelegramBot instance, String chatId) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "unpinChatMessage")
                    .field("chat_id", chatId, "application/json; charset=utf8;");

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }
}