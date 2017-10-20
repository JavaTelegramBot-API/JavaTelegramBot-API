package pro.zackpollard.telegrambot.api.chat;

import pro.zackpollard.telegrambot.api.chat.edit.UserRestrictions;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.InputFile;
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
     * Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this
     * to work and must have the appropriate admin rights. Pass True for all boolean parameters to lift restrictions
     * from a user
     *
     * @param userId            The ID of the user that you want to restrict
     * @param userRestrictions  The UserRestrictions object containing the restrictions you want to place on the user
     *
     * @return Returns True if the restrictions were applied successfully, False otherwise
     */
    default boolean restrictChatMember(int userId, UserRestrictions userRestrictions) {
        return Chat.restrictChatMember(getBotInstance(), getId(), userId, userRestrictions);
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

    /**
     * Use this method to pin a message in a supergroup. The bot must be an administrator in the chat for this to work
     * and must have the appropriate admin rights
     *
     * @param messageId             The ID of the message that you want to pin
     * @param disableNotification   True if you want to disable all users being notified about the new pinned message
     *
     * @return Returns True if the pinned message was set successfully, False otherwise
     */
    default boolean pinChatMessage(long messageId, boolean disableNotification) {
        return Chat.pinChatMessage(getBotInstance(), getId(), messageId, disableNotification);
    }

    /**
     * Use this method to pin a message in a supergroup. The bot must be an administrator in the chat for this to work
     * and must have the appropriate admin rights
     *
     * @param message               The Message that you want to pin
     * @param disableNotification   True if you want to disable all users being notified about the new pinned message
     *
     * @return Returns True if the pinned message was set successfully, False otherwise
     */
    default boolean pinChatMessage(Message message, boolean disableNotification) {
        return Chat.pinChatMessage(getBotInstance(), getId(), message.getMessageId(), disableNotification);
    }

    /**
     * Use this method to unpin a message in a supergroup chat. The bot must be an administrator in the chat for this to
     * work and must have the appropriate admin rights
     *
     * @return Returns True if the pinned message was set successfully, False otherwise
     */
    default boolean unpinChatMessage() {
        return Chat.unpinChatMessage(getBotInstance(), getId());
    }
}