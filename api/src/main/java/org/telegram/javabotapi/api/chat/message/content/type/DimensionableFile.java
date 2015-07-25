package org.telegram.javabotapi.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface DimensionableFile extends File {

    /**
     * Gets the width in pixels of the file
     *
     * @return The file width
     */
    int getWidth();

    /**
     * Gets the height in pixels of the file
     *
     * @return The file height
     */
    int getHeight();
}
