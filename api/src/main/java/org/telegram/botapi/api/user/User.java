package org.telegram.botapi.api.user;

import org.telegram.botapi.api.TelegramBot;

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

	UserProfilePhotos getProfilePhotos(TelegramBot telegramBot);
}