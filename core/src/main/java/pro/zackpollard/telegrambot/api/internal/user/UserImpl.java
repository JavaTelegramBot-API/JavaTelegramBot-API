package pro.zackpollard.telegrambot.api.internal.user;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.user.User;
import pro.zackpollard.telegrambot.api.user.UserProfilePhotos;

/**
 * @author Zack Pollard
 */
public class UserImpl implements User {

    private final long id;
    private final boolean is_bot;
    private final String first_name;
    private final String last_name;
    private final String username;
    private final String language_code;

    private UserImpl(JSONObject jsonObject) {

        this.id = jsonObject.getInt("id");
        this.is_bot = jsonObject.getBoolean("is_bot");
        this.first_name = jsonObject.getString("first_name");
        this.last_name = jsonObject.optString("last_name");
        this.username = "@" + jsonObject.optString("username");
        this.language_code = jsonObject.optString("language_code");
    }

    public static User createUser(JSONObject jsonObject) {

        return jsonObject != null ? new UserImpl(jsonObject) : null;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public boolean isBot() {
        return is_bot;
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
    public String getLanguageCode() {
        return language_code;
    }

    @Override
    public UserProfilePhotos getProfilePhotos(TelegramBot telegramBot) {

        return UserProfilePhotosImpl.createUserProfilePhotos(id, telegramBot);
    }
}
