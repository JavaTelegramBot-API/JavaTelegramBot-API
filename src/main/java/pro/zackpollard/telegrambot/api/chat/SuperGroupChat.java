package pro.zackpollard.telegrambot.api.chat;

/**
 * @author Zack Pollard
 */
public interface SuperGroupChat extends GroupChat {

    default ChatType getType() {

        return ChatType.SUPERGROUP;
    }

    String getUsername();

    boolean kickChatMember(int userId);

    boolean unbanChatMember(int userId);
}
