package pro.zackpollard.telegrambot.api.chat;

import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public interface IndividualChat extends Chat {

    /**
     * Gets the User that is in this conversation with the bot
     *
     * @return The User that is in this conversation with the bot
     */
    User getPartner();

    /**
     * Gets the ChatType of this Chat
     *
     * @return The ChatType of this Chat
     */
    default ChatType getType() {

        return ChatType.PRIVATE;
    }
}
