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

    private final TelegramBot telegramBot;

    private ChannelChatImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.username = "@" + jsonObject.optString("username");
        this.title = jsonObject.getString("title");
        this.photo = ChatPhotoImpl.createChatPhoto(jsonObject.optJSONObject("photo"));
        this.description = jsonObject.optString("description");
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
}
