package pro.zackpollard.telegrambot.api.internal.chat.message.content.type;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Sticker;

/**
 * @author Zack Pollard
 */
public class StickerImpl implements Sticker {

    private final String file_id;
    private final int width;
    private final int height;
    private final PhotoSize thumb;
    private final String emoji;
    private final Integer file_size;

    private StickerImpl(JSONObject jsonObject) {

        this.file_id = jsonObject.getString("file_id");
        this.width = jsonObject.getInt("width");
        this.height = jsonObject.getInt("height");
        this.thumb = PhotoSizeImpl.createPhotoSize(jsonObject.optJSONObject("thumb"));
        this.emoji = jsonObject.optString("emoji");
        this.file_size = jsonObject.optInt("file_size");
    }

    public static Sticker createSticker(JSONObject jsonObject) {

        return jsonObject != null ? new StickerImpl(jsonObject) : null;
    }

    /**
     * Gets the width in pixels of the file
     *
     * @return The file width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height in pixels of the file
     *
     * @return The file height
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Gets the Unique Identifier for this file
     *
     * @return The files ID
     */
    @Override
    public String getFileId() {
        return file_id;
    }

    /**
     * Gets the size of the file
     *
     * @return The file size
     */
    @Override
    public Integer getSize() {
        return file_size;
    }

    @Override
    public PhotoSize getThumbnail() {
        return thumb;
    }

    @Override
    public String getEmoji() {
        return emoji;
    }
}
