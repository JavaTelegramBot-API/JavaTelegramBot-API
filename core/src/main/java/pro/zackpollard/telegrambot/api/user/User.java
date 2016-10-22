package pro.zackpollard.telegrambot.api.user;

import pro.zackpollard.telegrambot.api.TelegramBot;

/**
 * @author Zack Pollard
 */
public interface User {

    /**
     * Gets the ID of the User
     *
     * @return The ID of the User
     */
    long getId();

    /**
     * Gets the first name of the User.
     *
     * @return The users first name, currently can be null due to chat creation of individual chats by ID with no way of getting the users name from telegram servers.
     */
    String getFirstName();

    /**
     * Gets the last name of the User
     *
     * @return The last name of the User or null if no last name is provided
     */
    String getLastName();

    /**
     * Gets the full name of the user (concatenates the first and last name with a space in the middle, and then trims
     *
     * @return The full name of the user
     */
    default String getFullName() {

        return (getFirstName() + " " + getLastName()).trim();
    }

    /**
     * Gets the username for the User
     *
     * @return The username for the User, or null if none is provided
     */
    String getUsername();

    /**
     * Gets the profile photos for the User
     *
     * @param telegramBot The TelegramBot instance that should retrieve the profile photos
     *
     * @return The UserProfilePhotos for the User
     */
    UserProfilePhotos getProfilePhotos(TelegramBot telegramBot);
}