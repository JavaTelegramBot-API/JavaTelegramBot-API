package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Document extends File, Mimetypeable, Thumbnailable {

    /**
     * Gets the file name of the document
     *
     * @return THe file name of the document
     */
    String getFileName();
}
