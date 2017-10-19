package pro.zackpollard.telegrambot.api.internal.chat.message.content.type;

import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;

/**
 * @author Zack Pollard
 */
@RequiredArgsConstructor
public class PhotoSizeImpl implements PhotoSize {

    private final String file_id;
    private final int width;
    private final int height;
    private final Integer file_size;

    private PhotoSizeImpl(JSONObject jsonObject) {

        this.file_id = jsonObject.getString("file_id");
        this.width = jsonObject.getInt("width");
        this.height = jsonObject.getInt("height");
        this.file_size = jsonObject.optInt("file_size");
    }


    public static PhotoSize createPhotoSize(JSONObject jsonObject) {

        return jsonObject != null ? new PhotoSizeImpl(jsonObject) : null;
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
    public int getSize() {
        return file_size;
    }
}
