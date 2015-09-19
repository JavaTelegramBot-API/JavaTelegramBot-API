package pro.zackpollard.telegrambot.api.internal.chat.message.content.type;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Voice;

/**
 * @author Zack Pollard
 */
public class VoiceImpl implements Voice {

	private final String file_id;
	private final int duration;
	private final String mime_type;
	private final int file_size;

	private VoiceImpl(JSONObject jsonObject) {

		this.file_id = jsonObject.getString("file_id");
		this.duration = jsonObject.getInt("duration");
		this.mime_type = jsonObject.optString("mime_type");
		this.file_size = jsonObject.optInt("file_size");
	}

	public static Voice createVoice(JSONObject jsonObject) {

		return jsonObject != null ? new VoiceImpl(jsonObject) : null;
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
}
