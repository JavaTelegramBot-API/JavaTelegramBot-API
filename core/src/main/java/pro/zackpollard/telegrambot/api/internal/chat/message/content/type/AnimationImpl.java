package pro.zackpollard.telegrambot.api.internal.chat.message.content.type;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Animation;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Audio;
import pro.zackpollard.telegrambot.api.chat.message.content.type.MessageEntity;
import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author Zack Pollard
 */
public class AnimationImpl implements Animation {

    private final String file_id;
    private final PhotoSize thumb;
    private final String file_name;
    private final String mime_type;
    private final Integer file_size;

    private AnimationImpl(JSONObject jsonObject) {

        this.file_id = jsonObject.getString("file_id");
        this.thumb = PhotoSizeImpl.createPhotoSize(jsonObject.getJSONObject("thumb"));
        this.file_name = jsonObject.optString("file_name");
        this.mime_type = jsonObject.optString("mime_type");
        this.file_size = jsonObject.optInt("file_size");
    }

    public static Animation createAnimation(JSONObject jsonObject) {

        return jsonObject != null ? new AnimationImpl(jsonObject) : null;
    }

    @Override
    public String getMimeType() {
        return mime_type;
    }

    @Override
    public PhotoSize getThumbnail() {
        return thumb;
    }

    @Override
    public String getFileId() {
        return file_id;
    }

    @Override
    public Integer getSize() {
        return file_size;
    }

    @Override
    public String getFileName() {
        return file_name;
    }
}
