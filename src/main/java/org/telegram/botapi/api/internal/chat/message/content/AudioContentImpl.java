package org.telegram.botapi.api.internal.chat.message.content;

import org.json.JSONObject;
import org.telegram.botapi.api.chat.message.content.AudioContent;
import org.telegram.botapi.api.chat.message.content.type.Audio;
import org.telegram.botapi.api.internal.chat.message.content.type.AudioImpl;

/**
 * @author Zack Pollard
 */
public class AudioContentImpl implements AudioContent {

	private final Audio content;

	private AudioContentImpl(JSONObject jsonObject) {

		this.content = AudioImpl.createAudio(jsonObject);
	}

	public static AudioContent createAudioContent(JSONObject jsonObject) {

		return jsonObject != null ? new AudioContentImpl(jsonObject) : null;
	}

	@Override
	public Audio getContent() {

		return content;
	}
}
