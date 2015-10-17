package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.Chat;

/**
 * @author Zack Pollard
 */
public class ChatImpl {

	public static Chat createChat(JSONObject jsonObject) {

		if (jsonObject.getInt("id") < 0) {

			return GroupChatImpl.createGroupChat(jsonObject);
		} else {

			return IndividualChatImpl.createIndividualChat(jsonObject);
		}
	}
}
