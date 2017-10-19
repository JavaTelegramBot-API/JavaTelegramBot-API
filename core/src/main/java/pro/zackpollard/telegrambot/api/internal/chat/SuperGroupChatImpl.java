package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.ChatPhoto;
import pro.zackpollard.telegrambot.api.chat.SuperGroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;

/**
 * @author Zack Pollard
 */
public class SuperGroupChatImpl implements SuperGroupChat {

    private final long id;
    private final String username;
    private final String title;
    private final boolean allMembersAreAdministrators;
    private final ChatPhoto photo;
    private final String description;
    private final String invite_link;

    private final TelegramBot telegramBot;

    private SuperGroupChatImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.id = jsonObject.getLong("id");
        this.username = "@" + jsonObject.optString("username");
        this.title = jsonObject.getString("title");
        this.allMembersAreAdministrators = jsonObject.optBoolean("all_members_are_administrators");
        this.photo = ChatPhotoImpl.createChatPhoto(jsonObject.optJSONObject("photo"));
        this.description = jsonObject.optString("description");
        this.invite_link = jsonObject.optString("invite_link");
        this.telegramBot = telegramBot;
    }

    public static SuperGroupChat createSuperGroupChat(JSONObject jsonObject, TelegramBot telegramBot) {

        return new SuperGroupChatImpl(jsonObject, telegramBot);
    }

    /**
     * Gets the name of the group chat.
     *
     * @return The group chat name, currently can be null due to chat creation by ID with no way of getting the group chats name from telegram servers.
     */
    @Override
    public String getName() {
        return title;
    }

    @Override
    public ChatPhoto getPhoto() {
        return photo;
    }

    @Override
    public TelegramBot getBotInstance() {
        return telegramBot;
    }

    @Override
    public String getId() {
        return String.valueOf(id);
    }

    @Override
    public Message sendMessage(SendableMessage message) {

        return telegramBot.sendMessage(this, message);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getInviteLink() {
        return invite_link;
    }

    @Override
    public boolean isAllMembersAreAdministrators() {
        return allMembersAreAdministrators;
    }

    @Override
    public boolean kickChatMember(int userId, long until_time) {

        return telegramBot.kickChatMember(this.getId(), userId, until_time);
    }

    @Override
    public boolean unbanChatMember(int userId) {

        return telegramBot.unbanChatMember(this.getId(), userId);
    }
}