package pro.zackpollard.telegrambot.api.chat.message.content;

/**
 * @author Zack Pollard
 */
public interface MigrateFromChatIDContent extends Content {

    long getContent();

    @Override
    default ContentType getType() {

        return ContentType.MIGRATE_FROM_CHAT_ID;
    }
}