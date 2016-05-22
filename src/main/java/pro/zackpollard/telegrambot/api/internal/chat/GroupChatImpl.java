package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.GroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.exception.TelegramApiException;

/**
 * @author Zack Pollard
 */
public class GroupChatImpl implements GroupChat {

    private final int id;
    private final String title;

    private final TelegramBot telegramBot;

    private GroupChatImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.id = jsonObject.getInt("id");
        this.title = jsonObject.getString("title");
        this.telegramBot = telegramBot;
    }

    private GroupChatImpl(int chatID, TelegramBot telegramBot) {

        this.id = chatID;
        this.title = null;
        this.telegramBot = telegramBot;
    }

    public static GroupChat createGroupChat(JSONObject jsonObject, TelegramBot telegramBot) {

        return new GroupChatImpl(jsonObject, telegramBot);
    }

    public static GroupChat createGroupChat(int chatID, TelegramBot telegramBot) {

        return new GroupChatImpl(chatID, telegramBot);
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
    public Message sendMessage(SendableMessage message) throws TelegramApiException {

        return telegramBot.sendMessage(this, message);
    }

    @Override
    public boolean kickChatMember(int userId) throws TelegramApiException {

        return telegramBot.kickChatMember(this.getId(), userId);
    }
}