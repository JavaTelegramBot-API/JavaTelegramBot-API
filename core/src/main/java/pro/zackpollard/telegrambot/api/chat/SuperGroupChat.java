package pro.zackpollard.telegrambot.api.chat;

import pro.zackpollard.telegrambot.api.chat.edit.UserRestrictions;

/**
 * @author Zack Pollard
 */
public interface SuperGroupChat extends GroupChat {

    default ChatType getType() {

        return ChatType.SUPERGROUP;
    }

    /**
     * Gets the Username of the SuperGroup that this SuperGroupChat object refers to
     *
     * @return The Username of this SuperGroup
     */
    String getUsername();

    /**
     * Gets the description of the SuperGroup that this SuperGroupChat object refers to
     * Only gets returned when the SuperGroupChat was retrieved from a call to getChat()
     *
     * @return The description of the SuperGroupChat
     */
    String getDescription();

    /**
     * Gets the invite link of the SuperGroup that this SuperGroupChat object refers to
     * Only gets returned when the SuperGroupChat was retrieved from a call to getChat()
     *
     * @return The invite link of the SuperGroupChat
     */
    String getInviteLink();

    /**
     * This method will kick and ban the User with the specified User ID from the chat if they are currently in it
     *
     * @deprecated Should use the new #kickChatMember(userId, until_time) method
     *
     * @param userId The User ID of the User you want to kick from the chat
     *
     * @return True if the user was kicked, otherwise False
     */
    @Deprecated
    default boolean kickChatMember(int userId) {
        return this.kickChatMember(userId, 0);
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

    boolean restrictChatMember(int userId, UserRestrictions userRestrictions);
}
