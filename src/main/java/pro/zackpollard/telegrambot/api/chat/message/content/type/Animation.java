package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Animation extends File, Thumbnailable, Mimetypeable {

    /**
     * Gets the name of the Animation file
     *
     * @return The name of the Animation file
     */
    String getFileName();
}