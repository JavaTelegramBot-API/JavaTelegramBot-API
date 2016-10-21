package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.MessageEntity;

import java.util.List;

/**
 * @author Zack Pollard
 */
public interface TextContent extends Content {

    /**
     * Gets the String object relating to this TextContent object
     *
     * @return The String object
     */
    String getContent();

    /**
     * Gets the list of MessageEntity objects that this TextContent contains
     *
     * @return A List of MessageEntity objects
     */
    List<MessageEntity> getEntities();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.TEXT;
    }
}
