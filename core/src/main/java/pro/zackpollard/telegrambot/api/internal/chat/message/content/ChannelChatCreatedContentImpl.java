package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.ChannelChatCreatedContent;

/**
 * @author Zack Pollard
 */
public class ChannelChatCreatedContentImpl implements ChannelChatCreatedContent {

    private ChannelChatCreatedContentImpl() {
    }

    public static ChannelChatCreatedContent createChannelChatCreatedContent() {

        return new ChannelChatCreatedContentImpl();
    }
}

