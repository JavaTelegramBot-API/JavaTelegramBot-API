package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.VideoNote;

/**
 * @author Zack Pollard
 */
public interface VideoNoteContent extends Content {

    /**
     * Gets the VideoNote object relating to this VideoNoteContent object
     *
     * @return The VideoNote object
     */
    VideoNote getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.VIDEO_NOTE;
    }
}
