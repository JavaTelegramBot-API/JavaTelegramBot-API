package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Contact;

/**
 * @author Zack Pollard
 */
public interface ContactContent extends Content {

	Contact getContent();

	@Override
	default ContentType getType() {

		return ContentType.CONTACT;
	}
}
