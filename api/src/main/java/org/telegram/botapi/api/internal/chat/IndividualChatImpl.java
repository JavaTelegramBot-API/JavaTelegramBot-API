package org.telegram.botapi.api.internal.chat;

import org.json.JSONObject;
import org.telegram.botapi.api.TelegramBot;
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

    public static IndividualChat createIndividualChat(JSONObject jsonObject) {

        return new IndividualChatImpl(jsonObject);
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