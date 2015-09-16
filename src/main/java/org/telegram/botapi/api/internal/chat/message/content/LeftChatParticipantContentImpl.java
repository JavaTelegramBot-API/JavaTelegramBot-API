package org.telegram.botapi.api.internal.chat.message.content;

import org.json.JSONObject;
import org.telegram.botapi.api.chat.message.content.LeftChatParticipantContent;
import org.telegram.botapi.api.internal.user.UserImpl;
import org.telegram.botapi.api.user.User;

/**
 * @author Zack Pollard
 */
public class LeftChatParticipantContentImpl implements LeftChatParticipantContent {

	private final User content;

	private LeftChatParticipantContentImpl(JSONObject jsonObject) {

		this.content = UserImpl.createUser(jsonObject);
	}

	public static LeftChatParticipantContent createLeftChatParticipantContent(JSONObject jsonObject) {

		return jsonObject != null ? new LeftChatParticipantContentImpl(jsonObject) : null;
	}

	/**
	 * Gets the participant who left the chat
	 *
	 * @return The previous participant, or null if there was no participant
	 */
	@Override
	public User getContent() {
		return content;
	}
}
