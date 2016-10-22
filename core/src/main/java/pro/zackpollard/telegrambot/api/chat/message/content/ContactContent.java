package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Contact;

/**
 * @author Zack Pollard
 */
public interface ContactContent extends Content {

    /**
     * Gets the Contact object relating to this ContactContent object
     *
     * @return The Contact object
     */
    Contact getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.CONTACT;
    }
}
