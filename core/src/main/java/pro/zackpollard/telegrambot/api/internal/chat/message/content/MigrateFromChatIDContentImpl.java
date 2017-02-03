package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.MigrateFromChatIDContent;

/**
 * @author Zack Pollard
 */
public class MigrateFromChatIDContentImpl implements MigrateFromChatIDContent {

    private final long content;

    private MigrateFromChatIDContentImpl(long content) {

        this.content = content;
    }

    public static MigrateFromChatIDContent createMigrateFromChatIDContent(long content) {

        return new MigrateFromChatIDContentImpl(content);
    }

    @Override
    public long getContent() {

        return content;
    }
}