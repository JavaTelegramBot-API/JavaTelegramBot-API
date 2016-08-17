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
}
