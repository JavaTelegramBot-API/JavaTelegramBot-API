package org.telegram.javabotapi.api.chat.message.content;

import org.telegram.javabotapi.api.chat.message.content.type.Document;

/**
 * @author Zack Pollard
 */
public interface DocumentContent extends Content {

    Document getContent();

    @Override
    default ContentType getType() {

        return ContentType.DOCUMENT;
    }
}
