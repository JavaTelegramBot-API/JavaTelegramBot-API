package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.GroupChat;
import pro.zackpollard.telegrambot.api.chat.SuperGroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;

/**
 * @author Zack Pollard
 */
public class SuperGroupChatImpl implements SuperGroupChat {

	private final long id;
	private final String title;

	private SuperGroupChatImpl(JSONObject jsonObject) {

		this.id = jsonObject.getLong("id");
		this.title = jsonObject.getString("title");
	}

	private SuperGroupChatImpl(long chatID) {

		this.id = chatID;
		this.title = null;
	}

	public static SuperGroupChat createSuperGroupChat(JSONObject jsonObject) {

		return new SuperGroupChatImpl(jsonObject);
	}

	public static SuperGroupChat createSuperGroupChat(long chatID) {

		return new SuperGroupChatImpl(chatID);
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