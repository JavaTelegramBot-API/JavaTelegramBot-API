package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.Message;

/**
 * @author Zack Pollard
 */
public interface PinnedMessageContent extends Content {

    /**
     * Gets the Message object relating to this PinnedMessageContent object
     *
     * @return The Message object
     */
    Message getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.PINNED_MESSAGE;
    }
}
