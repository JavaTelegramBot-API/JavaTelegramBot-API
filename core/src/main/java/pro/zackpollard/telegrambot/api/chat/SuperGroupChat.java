package pro.zackpollard.telegrambot.api.chat;

import pro.zackpollard.telegrambot.api.chat.edit.UserRestrictions;
import pro.zackpollard.telegrambot.api.user.UserPromotions;

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

    /**
     * Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this
     * to work and must have the appropriate admin rights. Pass True for all boolean parameters to lift restrictions
     * from a user
     *
     * @param userId            The ID of the user that you want to restrict
     * @param userRestrictions  The UserRestrictions object containing the restrictions you want to place on the user
     *
     * @return Returns True if the restrictions were applied successfully, False otherwise
     */
    boolean restrictChatMember(int userId, UserRestrictions userRestrictions);

    /**
     * Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the
     * chat for this to work and must have the appropriate admin rights. Pass False for all boolean parameters to demote
     * a user
     *
     * @param userId            The ID of the user that you want to promote
     * @param userPromotions    The UserPromotions object containing the promotions you want to place on the user
     *
     * @return Returns True if the promotions were applied successfully, False otherwise
     */
    boolean promoteChatMember(int userId, UserPromotions userPromotions);
}
