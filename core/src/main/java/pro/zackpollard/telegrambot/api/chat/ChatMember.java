package pro.zackpollard.telegrambot.api.chat;

import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public interface ChatMember {

    /**
     * Gets the User that this ChatMember object refers to
     *
     * @return The User that this ChatMember object refers to
     */
    User getUser();

    /**
     * Gets the ChatMemberStatus of this ChatMember
     *
     * @return The ChatMemberStatus of this ChatMember
     */
    ChatMemberStatus getStatus();

    /**
     * Restricted and kicked only. Date when restrictions will be lifted for this user, unix time
     *
     * @return The Unix Time that the user will be unrestricted/unbanned, null if there is no date
     */
    Long getUntilDate();

    /**
     * Administrators only. True, if the bot is allowed to edit administrator privileges of that user
     *
     * @return  True if the bot is allowed to edit administrator privileges of that user, False otherwise
     */
    boolean getCanBeEdited();

    /**
     * Administrators only. True, if the administrator can change the chat title, photo and other settings
     *
     * @return True if the administrator can change the chat title, photo and other settings, False otherwise
     */
    boolean getCanChangeInfo();

    /**
     * Administrators only. True, if the administrator can post in the channel, channels only
     *
     * @return True if the administrator can post in the channel, False otherwise
     */
    boolean getCanPostMessages();

    /**
     * Administrators only. True, if the administrator can edit messages of other users, channels only
     *
     * @return True if the administrator can edit messages of other users, False otherwise
     */
    boolean getCanEditMessages();

    /**
     * Administrators only. True, if the administrator can delete messages of other users
     *
     * @return True if the administrator can delete messages of other users, False otherwise
     */
    boolean getCanDeleteMessages();

    /**
     * Administrators only. True, if the administrator can invite new users to the chat
     *
     * @return True if the administrator can invite new users to the chat, False otherwise
     */
    boolean getCanInviteUsers();

    /**
     * Administrators only. True, if the administrator can restrict, ban or unban chat members
     *
     * @return True if the administrator can restrict, ban or unban chat members, False otherwise
     */
    boolean getCanRestrictMembers();

    /**
     * Administrators only. True, if the administrator can pin messages, supergroups only
     *
     * @return True if the administrator can pin messages, False otherwise
     */
    boolean getCanPinMessages();

    /**
     * Administrators only. True, if the administrator can add new administrators with a subset of his own privileges or
     * demote administrators that he has promoted, directly or indirectly (promoted by administrators that were
     * appointed by the user)
     *
     * @return True if the administrator can add new administrators, False otherwise
     */
    boolean getCanPromoteMembers();

    /**
     * Restricted only. True, if the user can send text messages, contacts, locations and venues
     *
     * @return True if the user can send text messages, contacts, locations and venues, False otherwise
     */
    boolean getCanSendMessages();

    /**
     * Restricted only. True, if the user can send audios, documents, photos, videos, video notes and voice notes,
     * implies can_send_messages
     *
     * @return True if the user can send audios, documents, photos, videos, video notes and voices notes, False otherwise
     */
    boolean getCanSendMediaMessages();

    /**
     * Restricted only. True, if the user can send animations, games, stickers and use inline bots, implies
     * can_send_media_messages
     *
     * @return True if the user can send animations, games, stickers and use inline bots, False otherwise
     */
    boolean getCanSendOtherMessages();

    /**
     * Restricted only. True, if user may add web page previews to their messages, implies can_send_media_messages
     *
     * @return True if the user may add web page previews to their messages, False otherwise
     */
    boolean getCanAddWebPagePreviews();
}
