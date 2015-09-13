package org.telegram.botapi.api.internal.chat;

import org.json.JSONObject;
import org.telegram.botapi.api.TelegramBot;
import org.telegram.botapi.api.chat.GroupChat;
import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.send.SendableMessage;

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

	@Override
	public String getName() {
		return title;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public Message sendMessage(SendableMessage message, TelegramBot telegramBot) {

		return telegramBot.sendMessage(this, message);
	}

	public static GroupChat createGroupChat(JSONObject jsonObject) {

        return new GroupChatImpl(jsonObject);
	}
}