package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface VideoNote extends DurationableFile, Thumbnailable {

    /**
     * The video width and height as defined by the sender
     * 
     * @return Width and Height of VideoNote
     */
    int getLength();
}
