package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;

/**
 * @author Zack Pollard
 */
public interface PhotoContent extends Content, Captionable {

    /**
     * Gets the PhotoSize array relating to this PhotoContent object
     *
     * @return The PhotoSize array
     */
    PhotoSize[] getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.PHOTO;
    }
}