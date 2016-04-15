package pro.zackpollard.telegrambot.api.chat.message.content;

/**
 * @author Zack Pollard
 */
public interface DeleteChatPhotoContent extends Content {

    default boolean getContent() {

        return true;
    }

    @Override
    default ContentType getType() {

        return ContentType.DELETE_CHAT_PHOTO;
    }
}