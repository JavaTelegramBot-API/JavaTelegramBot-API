package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author zackp
 */
public interface MessageEntity {

    MessageEntityType getType();

    int getOffset();

    int getLength();

    String getUrl();
}
