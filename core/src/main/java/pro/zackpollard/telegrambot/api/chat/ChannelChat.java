package pro.zackpollard.telegrambot.api.chat;

import pro.zackpollard.telegrambot.api.chat.message.send.InputFile;
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
    default boolean kickChatMember(int userId, long until_time) {
        return Chat.kickChatMember(getBotInstance(), getId(), userId, until_time);
    }

    /**
     * This method will unban a user that was previously banned from the chat
     *
     * @param userId The ID of the User you want to unban
     *
     * @return True if the user was unbanned, otherwise False
     */
    default boolean unbanChatMember(int userId) {
        return Chat.unbanChatMember(getBotInstance(), getId(), userId);
    }

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
    default boolean promoteChatMember(int userId, UserPromotions userPromotions) {
        return Chat.promoteChatMember(getBotInstance(), getId(), userId, userPromotions);
    }

    /**
     * Use this to export an invite link for this chat
     *
     * @return An invite link for this chat, or null if the export failed
     */
    default String exportChatInviteLink() {
        return Chat.exportChatInviteLink(getBotInstance(), getId());
    }

    /**
     * Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must
     * be an administrator in the chat for this to work and must have the appropriate admin rights
     *
     * @param inputFile     The InputFile form of the Photo that you would like to set as the chat photo
     *
     * @return Returns True if the chat image was set successfully, False otherwise
     */
    default boolean setChatPhoto(InputFile inputFile) {
        return Chat.setChatPhoto(getBotInstance(), getId(), inputFile);
    }

    /**
     * Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an
     * administrator in the chat for this to work and must have the appropriate admin rights
     *
     * @return Returns True if the chat image was deleted successfully, False otherwise
     */
    default boolean deleteChatPhoto() {
        return Chat.deleteChatPhoto(getBotInstance(), getId());
    }

    /**
     * Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an
     * administrator in the chat for this to work and must have the appropriate admin rights
     *
     * @param title     The title that you would like to be set for the chat
     *
     * @return Returns True if the title was set successfully, False otherwise
     */
    default boolean setChatTitle(String title) {
        return Chat.setChatTitle(getBotInstance(), getId(), title);
    }

    /**
     * Use this method to change the description of a supergroup or a channel. The bot must be an administrator in the
     * chat for this to work and must have the appropriate admin rights
     *
     * @param description   The description that you would like to be set for the chat
     *
     * @return Returns True if the description was set successfully, False otherwise
     */
    default boolean setChatDescription(String description) {
        return Chat.setChatDescription(getBotInstance(), getId(), description);
    }
}
