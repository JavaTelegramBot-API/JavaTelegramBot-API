package org.telegram.botapi.api.chat.message.content;

import org.telegram.botapi.api.chat.message.content.type.Contact;

/**
 * @author Zack Pollard
 */
public interface ContactContent extends Content {

    Contact getContent();

    @Override
    default ContentType getType() {

        return ContentType.CONTACT;
    }
}
