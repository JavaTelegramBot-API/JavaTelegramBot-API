package pro.zackpollard.telegrambot.api.chat;

import pro.zackpollard.telegrambot.api.user.UserPromotions;

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

    /**
     * Use this to export an invite link for this chat
     *
     * @return An invite link for this chat, or null if the export failed
     */
    String exportChatInviteLink();
}
