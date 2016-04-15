package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Venue;

/**
 * @author zackp
 */
public interface VenueContent extends Content {

    Venue getContent();

    @Override
    default ContentType getType() {

        return ContentType.VENUE;
    }
}
