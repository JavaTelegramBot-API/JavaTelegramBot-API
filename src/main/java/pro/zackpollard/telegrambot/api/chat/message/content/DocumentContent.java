package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Document;

/**
 * @author Zack Pollard
 */
public interface DocumentContent extends Content {

    /**
     * Gets the Document object relating to this DocumentContent object
     *
     * @return The Document object
     */
    Document getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.DOCUMENT;
    }
}
