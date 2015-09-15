package org.telegram.botapi.api.internal.chat.message.content;

import org.json.JSONObject;
import org.telegram.botapi.api.chat.message.content.Content;

/**
 * @author Zack Pollard
 */
public class ContentImpl {

	private final static String[] CONTENT_TYPE_NAMES = new String[]{
			"text", "audio", "document", "photo", "sticker",
			"video", "voice", "contact", "location", "new_chat_participant",
			"left_chat_participant", "new_chat_title", "new_chat_photo",
			"delete_chat_photo", "group_chat_created"
	};

	public static Content createContent(JSONObject jsonObject) {

		String messageType = null;

		for (String contentType : CONTENT_TYPE_NAMES) {

			if (!jsonObject.isNull(contentType)) {

				messageType = contentType;
				break;
			}
		}

		if (messageType != null) {
			switch (messageType) {

				case "text":

					return TextContentImpl.createTextContent(jsonObject.getString("text"));
				case "audio":

					return AudioContentImpl.createAudioContent(jsonObject.getJSONObject("audio"));
				case "document":

					return DocumentContentImpl.createDocumentContent(jsonObject.getJSONObject("document"));
				case "photo":

					return PhotoContentImpl.createPhotoContent(jsonObject.getJSONArray("photo"), jsonObject.optString("caption"));
				case "sticker":

					return StickerContentImpl.createStickerContent(jsonObject.getJSONObject("sticker"));
				case "video":

					return VideoContentImpl.createVideoContent(jsonObject.getJSONObject("video"), jsonObject.optString("caption"));
				case "voice":

					return VoiceContentImpl.createVoiceContent(jsonObject.getJSONObject("voice"));
				case "contact":

					return ContactContentImpl.createContactContent(jsonObject.getJSONObject("contact"));
				case "location":

					return LocationContentImpl.createLocationContent(jsonObject.getJSONObject("location"));
				case "new_chat_participant":

					return NewParticipantContentImpl.createNewParticipantContent(jsonObject.getJSONObject("new_chat_participant"));
				case "left_chat_participant":

					return LeftChatParticipantContentImpl.createLeftChatParticipantContent(jsonObject.getJSONObject("left_chat_participant"));
				case "new_chat_title":

					return NewChatTitleContentImpl.createNewChatTitleContent(jsonObject.getString("new_chat_title"));
				case "delete_chat_photo":

					return DeleteChatPhotoContentImpl.createDeleteChatPhotoContent();
				case "group_chat_created":

					return GroupChatCreatedContentImpl.createGroupChatCreatedContent();
			}
		}

		System.err.println("Unsupported message content received, report to developer. Supposed message type was " + (messageType != null ? messageType : "null"));
		return null;
	}
}
