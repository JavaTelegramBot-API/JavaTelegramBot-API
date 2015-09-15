package org.telegram.botapi.api.internal.chat.message.content;

import org.telegram.botapi.api.chat.message.content.GroupChatCreatedContent;

/**
 * @author Zack Pollard
 */
public class GroupChatCreatedContentImpl implements GroupChatCreatedContent {

	private GroupChatCreatedContentImpl() {
	}

	public static GroupChatCreatedContent createGroupChatCreatedContent() {

		return new GroupChatCreatedContentImpl();
	}
}
