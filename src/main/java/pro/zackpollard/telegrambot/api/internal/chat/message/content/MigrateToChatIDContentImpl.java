package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.MigrateToChatIDContent;

/**
 * @author Zack Pollard
 */
public class MigrateToChatIDContentImpl implements MigrateToChatIDContent {

    private final long content;

    private MigrateToChatIDContentImpl(long content) {

        this.content = content;
    }

    public static MigrateToChatIDContent createMigrateToChatIDContent(long content) {

        return new MigrateToChatIDContentImpl(content);
    }

    @Override
    public long getContent() {

        return content;
    }
}