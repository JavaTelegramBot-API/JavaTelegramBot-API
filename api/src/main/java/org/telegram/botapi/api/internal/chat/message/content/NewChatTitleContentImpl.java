package org.telegram.botapi.api.internal.chat.message.content;

import org.telegram.botapi.api.chat.message.content.Content;
import org.telegram.botapi.api.chat.message.content.NewChatTitleContent;

/**
 * @author Zack Pollard
 */
public class NewChatTitleContentImpl implements NewChatTitleContent {

	private final String content;

	private NewChatTitleContentImpl(String content) {

		this.content = content;
	}

	public static Content createNewChatTitleContent(String content) {

		return new NewChatTitleContentImpl(content);
	}

	/**
	 * Gets the new chat title
	 *
	 * @return The new chat title
	 */
	@Override
	public String getContent() {
		return content;
	}
}