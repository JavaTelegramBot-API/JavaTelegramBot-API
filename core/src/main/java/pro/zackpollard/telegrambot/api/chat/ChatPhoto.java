package pro.zackpollard.telegrambot.api.chat;

import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;

/**
 * @author Zack Pollard
 */
public interface ChatPhoto {

    /**
     * Get the PhotoSize object for the small Chat Photo.
     *
     * @return A PhotoSize object based off of the returned ID from the API.
     */
    PhotoSize getSmallFile();

    /**
     * Get the PhotoSize object for the large Chat Photo.
     *
     * @return A PhotoSize object based off of the return ID from the API.
     */
    PhotoSize getLargeFile();
}