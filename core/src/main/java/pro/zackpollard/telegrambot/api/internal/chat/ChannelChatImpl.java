package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.ChannelChat;
import pro.zackpollard.telegrambot.api.chat.ChatPhoto;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;

/**
 * @author Zack Pollard
 */
public class ChannelChatImpl implements ChannelChat {

    private final String username;
    private final String title;
    private final ChatPhoto photo;
    private final String description;
    private final String invite_link;

    private final TelegramBot telegramBot;

    private ChannelChatImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.username = "@" + jsonObject.optString("username");
        this.title = jsonObject.getString("title");
        this.photo = ChatPhotoImpl.createChatPhoto(jsonObject.optJSONObject("photo"));
        this.description = jsonObject.optString("description");
        this.invite_link = jsonObject.optString("invite_link");
        this.telegramBot = telegramBot;
    }

    public static ChannelChat createChannelChat(JSONObject jsonObject, TelegramBot telegramBot) {

        return new ChannelChatImpl(jsonObject, telegramBot);
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
        return username;
    }

    @Override
    public Message sendMessage(SendableMessage message) {

        return telegramBot.sendMessage(this, message);
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
