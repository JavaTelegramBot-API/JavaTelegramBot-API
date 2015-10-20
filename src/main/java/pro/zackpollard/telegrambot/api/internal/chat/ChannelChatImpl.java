package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.ChannelChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;

/**
 * @author Zack Pollard
 */
public class ChannelChatImpl implements ChannelChat {

    private final String username;
    private final String title;

    private ChannelChatImpl(JSONObject jsonObject) {

        this.username = jsonObject.getString("username");
        this.title = jsonObject.getString("title");
    }

    private ChannelChatImpl(String username) {

        this.username = username;
        this.title = null;
    }

    public static ChannelChat createChannelChat(JSONObject jsonObject) {

        return new ChannelChatImpl(jsonObject);
    }

    public static ChannelChat createChannelChat(String username) {

        return new ChannelChatImpl(username);
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String getId() {
        return username;
    }

    @Override
    public Message sendMessage(SendableMessage message, TelegramBot telegramBot) {

        return telegramBot.sendMessage(this, message);
    }
}
