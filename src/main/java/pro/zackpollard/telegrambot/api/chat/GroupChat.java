package pro.zackpollard.telegrambot.api.chat;

/**
 * @author Zack Pollard
 */
public interface GroupChat extends Chat {

    default ChatType getType() {

        return ChatType.GROUP;
    }
}