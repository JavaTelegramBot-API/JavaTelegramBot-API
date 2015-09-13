package org.telegram.botapi.api.user;

import org.telegram.botapi.api.chat.message.content.type.PhotoSize;

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
