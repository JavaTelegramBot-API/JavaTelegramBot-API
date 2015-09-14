package org.telegram.botapi.api.chat.message.send;

/**
 * @author Zack Pollard
 */
public enum ChatAction {

	TYPING_TEXT_MESSAGE("typing"),
	UPLOADING_PHOTO("upload_photo"),
	RECORDING_VIDEO("record_video"),
	UPLOADING_VIDEO("upload_video"),
	RECORD_AUDIO("record_audio"),
	UPLOAD_AUDIO("upload_audio"),
	UPLOAD_DOCUMENT("upload_document"),
	FIND_LOCATION("find_location");

	private final String name;

	ChatAction(String name) {

		this.name = name;
	}

	public String getName() {

		return name;
	}
}
