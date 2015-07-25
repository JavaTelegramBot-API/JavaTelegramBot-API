package org.telegram.javabotapi.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Video extends DimensionableFile, DurationableFile, Mimetypeable {

    //TODO: Change this to a interface rather than methods in each thumbnail enabled type.
    PhotoSize[] getThumbnail();
}
