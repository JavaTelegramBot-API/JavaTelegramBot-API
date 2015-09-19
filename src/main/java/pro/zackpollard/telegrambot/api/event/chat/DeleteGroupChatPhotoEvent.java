package pro.zackpollard.telegrambot.api.event.chat;

import pro.zackpollard.telegrambot.api.chat.GroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageEvent;

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
