package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.ChatPhoto;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Document;
import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.PhotoSizeImpl;

/**
 * @author Zack Pollard
 */
public class ChatPhotoImpl implements ChatPhoto {

    private final String small_file_id;
    private final String large_file_id;
    private final PhotoSize small_file;
    private final PhotoSize large_file;

    private ChatPhotoImpl(JSONObject jsonObject) {

        this.small_file_id = jsonObject.getString("small_file_id");
        this.large_file_id = jsonObject.getString("large_file_id");
        this.small_file = PhotoSizeImpl.createPhotoSize(small_file_id, 160, 160, null);
        this.large_file = PhotoSizeImpl.createPhotoSize(large_file_id, 640, 640, null);
    }

    public static ChatPhoto createChatPhoto(JSONObject jsonObject) {

        return jsonObject != null ? new ChatPhotoImpl(jsonObject) : null;
    }

    /**
     * Get the PhotoSize object for the small Chat Photo.
     *
     * @return A PhotoSize object based off of the returned ID from the API.
     */
    @Override
    public PhotoSize getSmallFile() {
        return small_file;
    }

    /**
     * Get the PhotoSize object for the large Chat Photo.
     *
     * @return A PhotoSize object based off of the return ID from the API.
     */
    @Override
    public PhotoSize getLargeFile() {
        return large_file;
    }
}
