package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Thumbnailable {

    /**
     * Gets the PhotoSize object relating to the thumbnail for the file, can be null
     *
     * @return The PhotoSize object for the files thumbnail or null if the file has no thumbnail
     */
    PhotoSize getThumbnail();
}
