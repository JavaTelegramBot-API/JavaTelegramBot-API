package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Video;

/**
 * @author Zack Pollard
 */
public interface VideoContent extends Content, Captionable {

    /**
     * Gets the Video object relating to this VideoContent object
     *
     * @return The Video object
     */
    Video getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.VIDEO;
    }
}
