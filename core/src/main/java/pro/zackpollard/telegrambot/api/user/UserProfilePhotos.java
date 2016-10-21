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

    /**
     * Gets an array containing all of the Photos that this User has
     * To download the photo you can get it down to a single PhotoSize object then call
     * PhotoSize#downloadFile(TelegramBot, File)
     *
     * @return An array of arrays of PhotoSize objects
     */
    PhotoSize[][] getPhotos();
}
