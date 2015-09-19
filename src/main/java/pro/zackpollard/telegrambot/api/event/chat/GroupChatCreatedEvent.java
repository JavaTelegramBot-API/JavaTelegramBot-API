package pro.zackpollard.telegrambot.api.event.chat;

import pro.zackpollard.telegrambot.api.chat.GroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageEvent;

/**
 * @author Zack Pollard
 */
public class GroupChatCreatedEvent extends MessageEvent {

	public GroupChatCreatedEvent(Message message) {
		super(message);
	}

	@Override
	public GroupChat getChat() {

		return (GroupChat) getMessage().getChat();
	}
}
