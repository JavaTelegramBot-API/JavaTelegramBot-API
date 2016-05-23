package pro.zackpollard.telegrambot.api.chat.message.content.type;

import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author zackp
 */
public interface MessageEntity {

    MessageEntityType getType();

    int getOffset();

    int getLength();

    String getUrl();

    User getUser();
}
