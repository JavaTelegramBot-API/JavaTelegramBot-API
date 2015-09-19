package pro.zackpollard.telegrambot.api.user;

import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;

/**
 * @author Zack Pollard
 */
public interface UserProfilePhotos {

	/**
	 * Get the total amount of photos this user has
	 *
	 * @return Amount of photos
	 */
	int getTotalCount();

	PhotoSize[][] getPhotos();
}
