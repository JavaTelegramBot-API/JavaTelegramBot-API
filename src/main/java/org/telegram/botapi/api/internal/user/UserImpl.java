package org.telegram.botapi.api.internal.user;

import org.json.JSONObject;
import org.telegram.botapi.api.TelegramBot;
import org.telegram.botapi.api.user.User;
import org.telegram.botapi.api.user.UserProfilePhotos;

/**
 * @author Zack Pollard
 */
public class UserImpl implements User {

	private final int id;
	private final String first_name;
	private final String last_name;
	private final String username;

	private UserImpl(JSONObject jsonObject) {

		this.id = jsonObject.getInt("id");
		this.first_name = jsonObject.getString("first_name");
		this.last_name = jsonObject.optString("last_name");
		this.username = jsonObject.optString("username");
	}

	private UserImpl(int userID) {

		this.id = userID;
		this.first_name = null;
		this.last_name = null;
		this.username = null;
	}

	public static User createUser(JSONObject jsonObject) {

		return jsonObject != null ? new UserImpl(jsonObject) : null;
	}

	public static User createUser(int userID) {

		return new UserImpl(userID);
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getFirstName() {
		return first_name;
	}

	@Override
	public String getLastName() {
		return last_name;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public UserProfilePhotos getProfilePhotos(TelegramBot telegramBot) {

		return UserProfilePhotosImpl.createUserProfilePhotos(id, telegramBot);
	}
}
