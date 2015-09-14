package org.telegram.botapi.api.internal.chat.message.content;

import org.json.JSONObject;
import org.telegram.botapi.api.chat.message.content.VoiceContent;
import org.telegram.botapi.api.chat.message.content.type.Voice;
import org.telegram.botapi.api.internal.chat.message.content.type.VoiceImpl;

/**
 * @author Zack Pollard
 */
public class VoiceContentImpl implements VoiceContent {

	private final Voice content;

	private VoiceContentImpl(JSONObject jsonObject) {

		this.content = VoiceImpl.createVoice(jsonObject);
	}

	public static VoiceContent createVoiceContent(JSONObject jsonObject) {

		return jsonObject != null ? new VoiceContentImpl(jsonObject) : null;
	}

	@Override
	public Voice getContent() {
		return content;
	}
}
