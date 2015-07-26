package org.telegram.javabotapi.api.user;

import org.telegram.javabotapi.api.chat.message.content.type.PhotoSize;

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

    default Set<Set<PhotoSize>> getPhotosSet() {

        Set<Set<PhotoSize>> photosSet = new HashSet<>();

        for (PhotoSize[] photoSizes : getPhotos()) {

            Set<PhotoSize> photoSizesSet = new HashSet<>();
            photosSet.add(photoSizesSet);

            for (PhotoSize photoSize : photoSizes) {

                photoSizesSet.add(photoSize);
            }
        }

        return photosSet;
    }
}
