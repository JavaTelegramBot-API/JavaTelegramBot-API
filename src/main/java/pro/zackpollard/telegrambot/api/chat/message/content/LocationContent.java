package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Location;

/**
 * @author Zack Pollard
 */
public interface LocationContent extends Content {

    /**
     * Gets the Location object relating to this LocationContent object
     *
     * @return The Location object
     */
    Location getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.LOCATION;
    }
}
