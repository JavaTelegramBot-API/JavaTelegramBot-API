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
     * Used to get whether all of the members in the chat are administrators
     *
     * @return True if all members are administrators, otherwise False
     */
    boolean isAllMembersAreAdministrators();

    /**
     * This method will kick and ban the User with the specified User ID from the chat if they are currently in it until
     * the unix time specified in the until_time field.
     *
     * @param userId        The User ID of the User you want to kick from the chat
     * @param until_time    The unix time when the User will be unbanned. If the time is less than 30 seconds or greater
     *                      than 366 days in the future, the User will be banned indefinitely
     *
     * @return True if the user was kicked, otherwise False
     */
    default boolean kickChatMember(int userId, long until_time) {
        return Chat.kickChatMember(getBotInstance(), getId(), userId, until_time);
    }
}