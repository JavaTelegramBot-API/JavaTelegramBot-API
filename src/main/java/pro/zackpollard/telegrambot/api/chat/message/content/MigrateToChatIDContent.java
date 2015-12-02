package pro.zackpollard.telegrambot.api.chat.message.content;

/**
 * @author Zack Pollard
 */
public interface MigrateToChatIDContent extends Content {

    long getContent();

    @Override
    default ContentType getType() {

        return ContentType.MIGRATE_TO_CHAT_ID;
    }
}