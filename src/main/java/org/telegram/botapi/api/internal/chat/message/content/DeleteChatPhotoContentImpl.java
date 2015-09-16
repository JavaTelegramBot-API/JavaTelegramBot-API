package org.telegram.botapi.api.internal.chat.message.content;

import org.telegram.botapi.api.chat.message.content.DeleteChatPhotoContent;

/**
 * @author Zack Pollard
 */
public class DeleteChatPhotoContentImpl implements DeleteChatPhotoContent {

	private DeleteChatPhotoContentImpl() {
	}

	public static DeleteChatPhotoContent createDeleteChatPhotoContent() {

		return new DeleteChatPhotoContentImpl();
	}
}
