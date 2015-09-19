package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.IndividualChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

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