package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Mimetypeable {

    /**
     * Gets the mimetype of the file, can be null
     *
     * @return The mimetype of the file or null if no mimetype is set
     */
    String getMimeType();
}
