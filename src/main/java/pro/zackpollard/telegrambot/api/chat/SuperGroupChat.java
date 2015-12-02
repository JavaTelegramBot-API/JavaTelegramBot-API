package pro.zackpollard.telegrambot.api.chat;

/**
 * @author Zack Pollard
 */
public interface SuperGroupChat extends Chat {

    String getName();

    default ChatType getType() {

        return ChatType.SUPERGROUP;
    }
}
