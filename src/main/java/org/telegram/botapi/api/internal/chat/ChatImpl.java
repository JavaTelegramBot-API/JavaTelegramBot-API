package org.telegram.botapi.api.internal.chat;

import org.json.JSONObject;
import org.telegram.botapi.api.chat.Chat;

/**
 * Created by zackp on 12/09/2015.
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
