package org.telegram.botapi.api.internal.chat.message.content.type;

import org.json.JSONObject;
import org.telegram.botapi.api.chat.message.content.type.PhotoSize;
import org.telegram.botapi.api.chat.message.content.type.Video;

/**
 * @author Zack Pollard
 */
public class VideoImpl implements Video {

	private final String file_id;
	private final int width;
	private final int height;
	private final int duration;
	private final PhotoSize thumb;
	private final String mime_type;
	private final int file_size;

	private VideoImpl(JSONObject jsonObject) {

		this.file_id = jsonObject.getString("file_id");
		this.width = jsonObject.getInt("width");
		this.height = jsonObject.getInt("height");
		this.duration = jsonObject.getInt("duration");
		this.thumb = PhotoSizeImpl.createPhotoSize(jsonObject.optJSONObject("thumb"));
		this.mime_type = jsonObject.optString("mime_type");
		this.file_size = jsonObject.optInt("file_size");
	}

	public static Video createVideo(JSONObject jsonObject) {

		return jsonObject != null ? new VideoImpl(jsonObject) : null;
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

	@Override
	public int getDuration() {
		return duration;
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

	@Override
	public String getMimeType() {
		return mime_type;
	}

	@Override
	public PhotoSize getThumbnail() {
		return thumb;
	}
}
