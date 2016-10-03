package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Animation extends File, Thumbnailable, Mimetypeable {

    String getFileName();
}