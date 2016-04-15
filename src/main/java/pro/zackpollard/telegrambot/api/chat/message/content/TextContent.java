package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.MessageEntity;

import java.util.List;

/**
 * @author Zack Pollard
 */
public interface TextContent extends Content {

    String getContent();

    List<MessageEntity> getEntities();

    @Override
    default ContentType getType() {

        return ContentType.TEXT;
    }
}
