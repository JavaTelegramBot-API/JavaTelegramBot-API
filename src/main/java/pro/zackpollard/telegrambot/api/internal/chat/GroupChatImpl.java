package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.GroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;

/**
 * @author Zack Pollard
 */
public class GroupChatImpl implements GroupChat {

    private final int id;
    private final String title;

    private GroupChatImpl(JSONObject jsonObject) {

        this.id = jsonObject.getInt("id");
        this.title = jsonObject.getString("title");
    }

    private GroupChatImpl(int chatID) {

        this.id = chatID;
        this.title = null;
    }

    public static GroupChat createGroupChat(JSONObject jsonObject) {

        return new GroupChatImpl(jsonObject);
    }

    public static GroupChat createGroupChat(int chatID) {

        return new GroupChatImpl(chatID);
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
    public String getId() {
        return String.valueOf(id);
    }

    @Override
    public Message sendMessage(SendableMessage message, TelegramBot telegramBot) {

        return telegramBot.sendMessage(this, message);
    }
}