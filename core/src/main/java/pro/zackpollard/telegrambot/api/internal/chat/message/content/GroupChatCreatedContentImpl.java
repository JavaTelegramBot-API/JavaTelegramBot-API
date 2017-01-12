package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.GroupChatCreatedContent;

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
