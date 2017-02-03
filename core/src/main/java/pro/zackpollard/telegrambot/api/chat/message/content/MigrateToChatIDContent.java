package pro.zackpollard.telegrambot.api.chat.message.content;

/**
 * @author Zack Pollard
 */
public interface MigrateToChatIDContent extends Content {

    /**
     * Gets the value relating to this MigrateFromChatIDContent object
     *
     * @return The ID of the chat that is being migrated to
     */
    long getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.MIGRATE_TO_CHAT_ID;
    }
}