package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.Chat;

/**
 * @author Zack Pollard
 */
public class ChatImpl {

	public static Chat createChat(JSONObject jsonObject) {

        String chatType = jsonObject.getString("type");

        switch(chatType) {

            case "private": return IndividualChatImpl.createIndividualChat(jsonObject);
            case "group":   return GroupChatImpl.createGroupChat(jsonObject);
            case "channel": return ChannelChatImpl.createChannelChat(jsonObject);
            case "supergroup": return SuperGroupChatImpl.createSuperGroupChat(jsonObject);
            default: System.err.println("An invalid chat type was provided when creating a chat object. Chat type " + chatType + " was provided. Report this to @zackpollard.");
        }

        return null;
	}
}
