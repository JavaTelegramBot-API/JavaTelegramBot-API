package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Audio;

/**
 * @author Zack Pollard
 */
public interface AudioContent extends Content {

    /**
     * Gets the Audio object relating to this AudioContent object
     *
     * @return The Audio object
     */
    Audio getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.AUDIO;
    }
}
