package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Audio extends DurationableFile, Mimetypeable {

    /**
     * Gets the performer for the audio file, can be null
     *
     * @return The performer for the audio file or null if no performer is set
     */
    String getPerformer();

    /**
     * Gets the title of the audio file, can be null
     *
     * @return The title of the audio file or null if no title is set
     */
    String getTitle();
}