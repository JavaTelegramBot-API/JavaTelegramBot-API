package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface DimensionableFile extends File {

    /**
     * Gets the width in pixels of the file
     *
     * @return The width of the media file in pixels
     */
    int getWidth();

    /**
     * Gets the height in pixels of the file
     *
     * @return The height of the media file in pixels
     */
    int getHeight();
}
