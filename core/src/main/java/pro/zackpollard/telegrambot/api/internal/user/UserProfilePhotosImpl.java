package pro.zackpollard.telegrambot.api.internal.user;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.PhotoSizeImpl;
import pro.zackpollard.telegrambot.api.user.UserProfilePhotos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class UserProfilePhotosImpl implements UserProfilePhotos {

    private final int total_count;
    private final PhotoSize[][] photos;

    private UserProfilePhotosImpl(JSONObject jsonObject) {

        this.total_count = jsonObject.getInt("total_count");

        List<List<PhotoSize>> photoList = new ArrayList<>();

        JSONArray jsonPhotos = jsonObject.getJSONArray("photos");

        for (int i = 0; i < jsonPhotos.length(); ++i) {

            JSONArray jsonPhotoSizes = jsonPhotos.getJSONArray(i);
            List<PhotoSize> photoSizesList = new ArrayList<>();

            for (int j = 0; j < jsonPhotoSizes.length(); ++j) {

                JSONObject photoObject = jsonPhotoSizes.getJSONObject(j);
                photoSizesList.add(PhotoSizeImpl.createPhotoSize(photoObject));
            }

            photoList.add(photoSizesList);
        }

        photos = photoList.stream()
                .map(l -> l.stream().toArray(PhotoSize[]::new))
                .toArray(PhotoSize[][]::new);
    }

    public static UserProfilePhotos createUserProfilePhotos(long user_id, TelegramBot telegramBot) {

        try {
            JSONObject json = Unirest.post(telegramBot.getBotAPIUrl() + "getUserProfilePhotos")
                    .queryString("user_id", user_id).asJson().getBody().getObject();
            if(json.getBoolean("ok")) {
                return new UserProfilePhotosImpl(json.getJSONObject("result"));
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get the total amount of photos this user has
     *
     * @return Amount of photos
     */
    @Override
    public int getTotalCount() {
        return total_count;
    }

    @Override
    public PhotoSize[][] getPhotos() {

        return photos;
    }
}
