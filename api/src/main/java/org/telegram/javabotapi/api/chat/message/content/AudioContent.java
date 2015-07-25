package org.telegram.javabotapi.api.chat.message.content;

import org.telegram.javabotapi.api.chat.message.content.type.Audio;

/**
 * @author Zack Pollard
 */
public interface AudioContent extends Content {

    Audio getContent();

    @Override
    default ContentType getType() {

        return ContentType.AUDIO;
    }
}
