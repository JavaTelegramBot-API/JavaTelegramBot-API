package org.telegram.botapi.api.event.chat;

import org.telegram.botapi.api.chat.GroupChat;
import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.content.PhotoContent;
import org.telegram.botapi.api.chat.message.content.type.PhotoSize;
import org.telegram.botapi.api.event.chat.message.MessageEvent;

/**
 * @author Zack Pollard
 */
public class NewGroupChatPhotoEvent extends MessageEvent {

	public NewGroupChatPhotoEvent(Message message) {
		super(message);
	}

	@Override
	public GroupChat getChat() {

		return (GroupChat) getMessage().getChat();
	}

	public PhotoSize[] getContent() {

		return ((PhotoContent) getMessage().getContent()).getContent();
	}
}
