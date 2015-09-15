package org.telegram.botapi.api.internal.chat.message.content;

import org.json.JSONObject;
import org.telegram.botapi.api.chat.message.content.NewParticipantContent;
import org.telegram.botapi.api.internal.user.UserImpl;
import org.telegram.botapi.api.user.User;

/**
 * @author Zack Pollard
 */
public class NewParticipantContentImpl implements NewParticipantContent {

	private final User content;

	private NewParticipantContentImpl(JSONObject jsonObject) {

		this.content = UserImpl.createUser(jsonObject);
	}

	public static NewParticipantContent createNewParticipantContent(JSONObject jsonObject) {

		return jsonObject != null ? new NewParticipantContentImpl(jsonObject) : null;
	}

	/**
	 * Gets the new participant in the chat
	 *
	 * @return The new participant, or null if there was no new participant
	 */
	@Override
	public User getContent() {
		return content;
	}
}
