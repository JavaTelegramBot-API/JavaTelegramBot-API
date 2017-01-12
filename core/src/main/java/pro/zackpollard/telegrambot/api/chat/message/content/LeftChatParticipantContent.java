package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public interface LeftChatParticipantContent extends Content {

    /**
     * Gets the participant who left the chat
     *
     * @return The previous participant, or null if there was no participant
     */
    User getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.LEFT_CHAT_PARTICIPANT;
    }
}
