package org.telegram.botapi.api.chat.message.content;

/**
 * @author Zack Pollard
 */
public interface GroupChatCreatedContent extends Content {

	default boolean getContent() {

		return true;
	}

	@Override
	default ContentType getType() {

		return ContentType.GROUP_CHAT_CREATED;
	}
}
