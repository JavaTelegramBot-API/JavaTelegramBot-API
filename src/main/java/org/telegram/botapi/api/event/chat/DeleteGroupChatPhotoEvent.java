package org.telegram.botapi.api.event.chat;

import org.telegram.botapi.api.chat.GroupChat;
import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.event.chat.message.MessageEvent;

/**
 * @author Zack Pollard
 */
public class DeleteGroupChatPhotoEvent extends MessageEvent {

	public DeleteGroupChatPhotoEvent(Message message) {
		super(message);
	}

	public GroupChat getChat() {

		return (GroupChat) getMessage().getChat();
	}
}
