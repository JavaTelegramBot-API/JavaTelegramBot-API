package org.telegram.botapi.api.event.chat;

import org.telegram.botapi.api.chat.GroupChat;
import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.event.chat.message.MessageEvent;

/**
 * @author Zack Pollard
 */
public class NewGroupChatTitleEvent extends MessageEvent {

	public NewGroupChatTitleEvent(Message message) {
		super(message);
	}

	@Override
	public GroupChat getChat() {

		return (GroupChat) getMessage().getChat();
	}

	public String getTitle() {

		return getChat().getName();
	}
}
