package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.SuperGroupChatCreatedContent;

/**
 * @author Zack Pollard
 */
public class SuperGroupChatCreatedContentImpl implements SuperGroupChatCreatedContent {

    private SuperGroupChatCreatedContentImpl() {
    }

    public static SuperGroupChatCreatedContent createSuperGroupChatCreatedContent() {

        return new SuperGroupChatCreatedContentImpl();
    }
}

