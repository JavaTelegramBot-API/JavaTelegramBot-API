package pro.zackpollard.telegrambot.api.event.chat;

import pro.zackpollard.telegrambot.api.chat.ChannelChat;
import pro.zackpollard.telegrambot.api.chat.GroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageEvent;

/**
 * @author Zack Pollard
 */
public class ChannelChatCreatedEvent extends MessageEvent {

	public ChannelChatCreatedEvent(Message message) {
		super(message);
	}

	@Override
	public ChannelChat getChat() {

		return (ChannelChat) getMessage().getChat();
	}
}
