package pro.zackpollard.telegrambot.api.internal.chat.message.content.type;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Audio;

/**
 * @author Zack Pollard
 */
public class AudioImpl implements Audio {

    private final String file_id;
    private final int duration;
    private final String performer;
    private final String title;
    private final String mime_type;
    private final int file_size;

    private AudioImpl(JSONObject jsonObject) {

        this.file_id = jsonObject.getString("file_id");
        this.duration = jsonObject.getInt("duration");
        this.performer = jsonObject.optString("performer");
        this.title = jsonObject.optString("title");
        this.mime_type = jsonObject.optString("mime_type");
        this.file_size = jsonObject.optInt("file_size");
    }

    public static Audio createAudio(JSONObject jsonObject) {

        return jsonObject != null ? new AudioImpl(jsonObject) : null;
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
    public String getMimeType() {
        return mime_type;
    }

    @Override
    public String getPerformer() {
        return performer;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
