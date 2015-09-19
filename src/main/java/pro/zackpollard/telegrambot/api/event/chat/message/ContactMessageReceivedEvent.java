package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.ContactContent;

/**
 * @author Zack Pollard
 */
public class ContactMessageReceivedEvent extends MessageReceivedEvent {

	public ContactMessageReceivedEvent(Message message) {

		super(message);
	}

	@Override
	public ContactContent getContent() {

		return (ContactContent) getMessage().getContent();
	}
}