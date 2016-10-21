package pro.zackpollard.telegrambot.api.chat;

/**
 * @author Zack Pollard
 */
public interface GroupChat extends Chat {

    /**
     * Gets the ChatType of this Chat
     *
     * @return The ChatType of this Chat
     */
    default ChatType getType() {

        return ChatType.GROUP;
    }

    /**
     * This method will kick the User with the specified User ID from the chat if they are currently in it
     *
     * @param userId The User ID of the User you want to kick from the chat
     *
     * @return True if the user was kicked, otherwise False
     */
    boolean kickChatMember(int userId);
}