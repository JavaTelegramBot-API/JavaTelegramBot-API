package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.ChannelChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;

/**
 * @author Zack Pollard
 */
public class PrivateChannelChatImpl implements ChannelChat {

    private final String username;
    private final String title;

    private final TelegramBot telegramBot;

    private PrivateChannelChatImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.username = jsonObject.optString("id");
        this.title = jsonObject.getString("title");
        this.telegramBot = telegramBot;
    }

    private PrivateChannelChatImpl(String username, TelegramBot telegramBot) {

        this.username = username;
        this.title = null;
        this.telegramBot = telegramBot;
    }

    public static ChannelChat createChannelChat(JSONObject jsonObject, TelegramBot telegramBot) {

        return new PrivateChannelChatImpl(jsonObject, telegramBot);
    }

    public static ChannelChat createChannelChat(String username, TelegramBot telegramBot) {

        return new PrivateChannelChatImpl(username, telegramBot);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getName() {
        return title;
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
