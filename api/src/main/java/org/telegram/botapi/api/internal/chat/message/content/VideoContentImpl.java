package org.telegram.botapi.api.internal.chat.message.content;

import org.json.JSONObject;
import org.telegram.botapi.api.chat.message.content.VideoContent;
import org.telegram.botapi.api.chat.message.content.type.Video;
import org.telegram.botapi.api.internal.chat.message.content.type.VideoImpl;

/**
 * @author Zack Pollard
 */
public class VideoContentImpl implements VideoContent {

	private final Video content;
	private final String caption;

	private VideoContentImpl(JSONObject jsonObject, String caption) {

		this.content = VideoImpl.createVideo(jsonObject);
		this.caption = caption;
	}

	public static VideoContent createVideoContent(JSONObject jsonObject, String caption) {

		return jsonObject != null ? new VideoContentImpl(jsonObject, caption) : null;
	}

	@Override
	public Video getContent() {

		return content;
	}

	@Override
	public String getCaption() {

		return caption;
	}
}
