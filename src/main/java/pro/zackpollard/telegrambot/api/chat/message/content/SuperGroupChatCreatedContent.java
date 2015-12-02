package pro.zackpollard.telegrambot.api.chat.message.content;

/**
 * @author Zack Pollard
 */
public interface SuperGroupChatCreatedContent extends Content {

    default boolean getContent() {

        return true;
    }

    @Override
    default ContentType getType() {

        return ContentType.SUPER_GROUP_CHAT_CREATED;
    }
}