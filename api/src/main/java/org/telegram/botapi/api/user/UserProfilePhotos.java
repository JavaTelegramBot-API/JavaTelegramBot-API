package org.telegram.botapi.api.user;

import org.telegram.botapi.api.chat.message.content.type.PhotoSize;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zack Pollard
 */
public interface UserProfilePhotos {

    /**
     * Get the total amount of photos this user has
     *
     * @return Amount of photos
     */
    default int getTotalCount() {

        return getPhotos().length;
    }

    PhotoSize[][] getPhotos();
}
