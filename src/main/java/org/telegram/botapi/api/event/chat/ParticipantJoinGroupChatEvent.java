package org.telegram.botapi.api.event.chat;

import org.telegram.botapi.api.chat.Chat;
import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.content.NewChatParticipantContent;
import org.telegram.botapi.api.event.chat.message.MessageEvent;
import org.telegram.botapi.api.user.User;

/**
 * @author Zack Pollard
 */
public class ParticipantJoinGroupChatEvent extends MessageEvent {

	public ParticipantJoinGroupChatEvent(Message message) {
		super(message);
	}

	public User getParticipant() {

		return ((NewChatParticipantContent) getMessage().getContent()).getContent();
	}

	public Chat getChat() {

		return getMessage().getChat();
	}
}
