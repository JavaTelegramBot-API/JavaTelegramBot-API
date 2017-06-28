package pro.zackpollard.telegrambot.api.internal.chat.message.content.type;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Video;
import pro.zackpollard.telegrambot.api.chat.message.content.type.VideoNote;

/**
 * @author Zack Pollard
 */
public class VideoNoteImpl implements VideoNote {

    private final String file_id;
    private final int length;
    private final int duration;
    private final PhotoSize thumb;
    private final int file_size;

    private VideoNoteImpl(JSONObject jsonObject) {

        this.file_id = jsonObject.getString("file_id");
        this.length = jsonObject.getInt("length");
        this.duration = jsonObject.getInt("duration");
        this.thumb = PhotoSizeImpl.createPhotoSize(jsonObject.optJSONObject("thumb"));
        this.file_size = jsonObject.optInt("file_size");
    }

    public static VideoNote createVideoNote(JSONObject jsonObject) {

        return jsonObject != null ? new VideoNoteImpl(jsonObject) : null;
    }
    
    @Override
    public int getLength() {
        return length;
    }
    
    @Override
    public int getDuration() {
        return duration;
    }
    
    @Override
    public String getFileId() {
        return file_id;
    }
    
    @Override
    public int getSize() {
        return file_size;
    }

    @Override
    public PhotoSize getThumbnail() {
        return thumb;
    }
}
