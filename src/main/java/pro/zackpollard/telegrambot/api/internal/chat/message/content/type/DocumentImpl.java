package pro.zackpollard.telegrambot.api.internal.chat.message.content.type;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Document;
import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;

/**
 * @author Zack Pollard
 */
public class DocumentImpl implements Document {

	private final String file_id;
	private final PhotoSize thumb;
	private final String file_name;
	private final String mime_type;
	private final int file_size;

	private DocumentImpl(JSONObject jsonObject) {

		this.file_id = jsonObject.getString("file_id");
		this.thumb = PhotoSizeImpl.createPhotoSize(jsonObject.optJSONObject("thumb"));
		this.file_name = jsonObject.optString("file_name");
		this.mime_type = jsonObject.optString("mime_type");
		this.file_size = jsonObject.optInt("file_size");
	}

	public static Document createDocument(JSONObject jsonObject) {

		return jsonObject != null ? new DocumentImpl(jsonObject) : null;
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

    @Override
    public String getFileName() {

        return file_name;
    }
}
