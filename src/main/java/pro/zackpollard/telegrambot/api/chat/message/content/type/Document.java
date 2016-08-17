package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Document extends File, Mimetypeable, Thumbnailable {

    /**
     *
     *
     * @return
     */
    String getFileName();
}
