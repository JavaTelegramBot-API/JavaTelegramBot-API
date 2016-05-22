package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.ChannelChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.exception.TelegramApiException;

/**
 * @author Zack Pollard
 */
public class ChannelChatImpl implements ChannelChat {

    private final String username;
    private final String title;

    private final TelegramBot telegramBot;

    private ChannelChatImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.username = jsonObject.getString("username");
        this.title = jsonObject.getString("title");
        this.telegramBot = telegramBot;
    }

    private ChannelChatImpl(String username, TelegramBot telegramBot) {

        this.username = username;
        this.title = null;
        this.telegramBot = telegramBot;
    }

    public static ChannelChat createChannelChat(JSONObject jsonObject, TelegramBot telegramBot) {

        return new ChannelChatImpl(jsonObject, telegramBot);
    }

    public static ChannelChat createChannelChat(String username, TelegramBot telegramBot) {

        return new ChannelChatImpl(username, telegramBot);
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
    public Message sendMessage(SendableMessage message) throws TelegramApiException {

        return telegramBot.sendMessage(this, message);
    }
}
