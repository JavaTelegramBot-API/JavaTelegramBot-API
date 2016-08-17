package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Venue;

/**
 * @author zackp
 */
public interface VenueContent extends Content {

    /**
     * Gets the Venue object relating to this VenueContent object
     *
     * @return The Venue object
     */
    Venue getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.VENUE;
    }
}
