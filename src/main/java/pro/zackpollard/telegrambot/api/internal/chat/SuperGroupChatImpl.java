package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.SuperGroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;

/**
 * @author Zack Pollard
 */
public class SuperGroupChatImpl implements SuperGroupChat {

    private final long id;
    private final String title;

    private final TelegramBot telegramBot;

    private SuperGroupChatImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.id = jsonObject.getLong("id");
        this.title = jsonObject.getString("title");
        this.telegramBot = telegramBot;
    }

    private SuperGroupChatImpl(long chatID, TelegramBot telegramBot) {

        this.id = chatID;
        this.title = null;
        this.telegramBot = telegramBot;
    }

    public static SuperGroupChat createSuperGroupChat(JSONObject jsonObject, TelegramBot telegramBot) {

        return new SuperGroupChatImpl(jsonObject, telegramBot);
    }

    public static SuperGroupChat createSuperGroupChat(long chatID, TelegramBot telegramBot) {

        return new SuperGroupChatImpl(chatID, telegramBot);
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
    public boolean kickChatMember(int userId) {

        return telegramBot.kickChatMember(this.getId(), userId);
    }
}