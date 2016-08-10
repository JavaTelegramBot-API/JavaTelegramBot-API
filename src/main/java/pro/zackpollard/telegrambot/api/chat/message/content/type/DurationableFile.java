package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface DurationableFile extends File {

    /**
     * Gets the duration of the media file
     *
     * @return The duration of the media file
     */
    int getDuration();
}
