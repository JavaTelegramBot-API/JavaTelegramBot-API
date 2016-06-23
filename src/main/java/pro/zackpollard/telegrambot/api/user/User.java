package pro.zackpollard.telegrambot.api.user;

import pro.zackpollard.telegrambot.api.TelegramBot;

/**
 * @author Zack Pollard
 */
public interface User {

    long getId();

    /**
     * Gets the first name of the user.
     *
     * @return The users first name, currently can be null due to chat creation of individual chats by ID with no way of getting the users name from telegram servers.
     */
    String getFirstName();

    String getLastName();

    default String getFullName() {

        return (getFirstName() + " " + getLastName()).trim();
    }

    String getUsername();

    UserProfilePhotos getProfilePhotos(TelegramBot telegramBot);
}