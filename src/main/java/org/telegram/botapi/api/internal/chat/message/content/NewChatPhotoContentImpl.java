package org.telegram.botapi.api.internal.chat.message.content;

import org.json.JSONArray;
import org.json.JSONObject;
import org.telegram.botapi.api.chat.message.content.NewChatPhotoContent;
import org.telegram.botapi.api.chat.message.content.type.PhotoSize;
import org.telegram.botapi.api.internal.chat.message.content.type.PhotoSizeImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class NewChatPhotoContentImpl implements NewChatPhotoContent {

	private final PhotoSize[] content;

	private NewChatPhotoContentImpl(JSONArray jsonArray) {

		List<PhotoSize> photoSizeList = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); ++i) {

			JSONObject photoObject = jsonArray.getJSONObject(i);
			photoSizeList.add(PhotoSizeImpl.createPhotoSize(photoObject));
		}

		content = photoSizeList.stream()
				.toArray(PhotoSize[]::new);
	}

	public static NewChatPhotoContent createNewChatPhotoContent(JSONArray jsonArray) {

		return new NewChatPhotoContentImpl(jsonArray);
	}

	/**
	 * Gets the new photo for the chat
	 *
	 * @return The new photo.
	 */
	@Override
	public PhotoSize[] getContent() {
		return content;
	}
}
