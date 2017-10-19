package pro.zackpollard.telegrambot.api.chat;

/**
 * @author Zack Pollard
 */
public interface ChannelChat extends Chat {

    /**
     * Gets the Username of the Channel that this ChannelChat object refers to
     *
     * @return The Username of this Channel
     */
    String getUsername();

    /**
     * Gets the description of the Channel that this ChannelChat object refers to
     * Only gets returned when the ChannelChat was retrieved from a call to getChat()
     *
     * @return The description of the ChannelChat
     */
    String getDescription();

    /**
     * Gets the invite link of the Channel that this ChannelChat object refers to
     * Only gets returned when the ChannelChat was retrieved from a call to getChat()
     *
     * @return The invite link of the ChannelChat
     */
    String getInviteLink();

    /**
     * Gets the ChatType of this Chat
     *
     * @return The ChatType of this Chat
     */
    default ChatType getType() {

        return ChatType.CHANNEL;
    }

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
    boolean kickChatMember(int userId, long until_time);

    /**
     * This method will unban a user that was previously banned from the chat
     *
     * @param userId The ID of the User you want to unban
     *
     * @return True if the user was unbanned, otherwise False
     */
    boolean unbanChatMember(int userId);
}
