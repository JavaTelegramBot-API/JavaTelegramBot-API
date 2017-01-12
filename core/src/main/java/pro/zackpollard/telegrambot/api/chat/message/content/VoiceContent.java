package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Voice;

/**
 * @author Zack Pollard
 */
public interface VoiceContent extends Content {

    /**
     * Gets the Voice object relating to this VoiceContent object
     *
     * @return The Voice object
     */
    Voice getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {
        return ContentType.VOICE;
    }
}
