package pro.zackpollard.telegrambot.api.chat.message.content;

/**
 * @author Zack Pollard
 */
public interface ChannelChatCreatedContent extends Content {

    default boolean getContent() {

        return true;
    }

    @Override
    default ContentType getType() {

        return ContentType.CHANNEL_CHAT_CREATED;
    }
}