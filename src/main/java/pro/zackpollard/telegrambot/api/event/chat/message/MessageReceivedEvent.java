package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.Content;

/**
 * @author Zack Pollard
 */

public class MessageReceivedEvent extends MessageEvent {

	public MessageReceivedEvent(Message message) {

		super(message);
	}

	public Content getContent() {

		return getMessage().getContent();
	}
}
