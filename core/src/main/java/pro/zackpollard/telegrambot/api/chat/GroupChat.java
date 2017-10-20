package pro.zackpollard.telegrambot.api.chat;

import pro.zackpollard.telegrambot.api.chat.message.send.InputFile;

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
}