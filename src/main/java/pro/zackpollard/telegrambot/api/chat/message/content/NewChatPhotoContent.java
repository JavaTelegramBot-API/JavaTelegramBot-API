package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;

/**
 * @author Zack Pollard
 */
public interface NewChatPhotoContent extends Content {

	/**
	 * Gets the new photo for the chat
	 *
	 * @return The new photo.
	 */
	PhotoSize[] getContent();

	@Override
	default ContentType getType() {

		return ContentType.NEW_CHAT_PHOTO;
	}
}
