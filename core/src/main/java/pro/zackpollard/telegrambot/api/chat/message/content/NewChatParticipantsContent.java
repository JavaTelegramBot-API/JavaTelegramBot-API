package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.user.User;

import java.util.Set;

/**
 * @author Zack Pollard
 */
public interface NewChatParticipantsContent extends Content {

    /**
     * Gets the new participant in the chat
     *
     * @return The new participant, or null if there was no new participant
     */
    Set<User> getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.NEW_CHAT_PARTICIPANTS;
    }
}
