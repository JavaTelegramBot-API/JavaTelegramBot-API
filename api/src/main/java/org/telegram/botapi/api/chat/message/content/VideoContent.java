package org.telegram.botapi.api.chat.message.content;

import org.telegram.botapi.api.chat.message.content.type.Video;

/**
 * @author Zack Pollard
 */
public interface VideoContent extends Content, Captionable {

    Video getContent();

    @Override
    default ContentType getType() {

        return ContentType.VIDEO;
    }
}
