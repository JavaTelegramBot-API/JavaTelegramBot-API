package org.telegram.javabotapi.api.user;

/**
 * @author Zack Pollard
 */
public interface User {

    int getId();

    String getFirstName();

    String getLastName();

    default String getFullName() {

        return getFirstName() + " " + getLastName();
    }

    String getUsername();

    UserProfilePhotos getProfilePhotos();
}
