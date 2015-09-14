package org.telegram.botapi.api.internal.chat;

import org.json.JSONObject;
import org.telegram.botapi.api.TelegramBot;
import org.telegram.botapi.api.chat.Chat;
import org.telegram.botapi.api.chat.IndividualChat;
import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.send.SendableMessage;
import org.telegram.botapi.api.internal.user.UserImpl;
import org.telegram.botapi.api.user.User;

/**
 * @author Zack Pollard
 */
public class IndividualChatImpl implements IndividualChat {

	private final User partner;

	private IndividualChatImpl(JSONObject jsonObject) {

		this.partner = UserImpl.createUser(jsonObject);
    }

	private IndividualChatImpl(int userID) {

		this.partner = UserImpl.createUser(userID);
	}

    public static IndividualChat createIndividualChat(JSONObject jsonObject) {

        return new IndividualChatImpl(jsonObject);
    }

	public static Chat createIndividualChat(int chatID) {

		return new IndividualChatImpl(chatID);
	}

	@Override
	public User getPartner() {

		return partner;
	}

	@Override
	public int getId() {

		return partner.getId();
	}

	@Override
	public Message sendMessage(SendableMessage message, TelegramBot telegramBot) {

		return telegramBot.sendMessage(this, message);
	}
}