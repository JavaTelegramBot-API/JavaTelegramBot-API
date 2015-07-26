package org.telegram.botapi.api.chat.message.content;

import org.telegram.botapi.api.user.User;

/**
 * @author Zack Pollard
 */
public interface NewParticipantContent extends Content {

    /**
     * Gets the new participant in the chat
     *
     * @return The new participant, or null if there was no new participant
     */
    User getContent();

    @Override
    default ContentType getType() {

        return ContentType.NEW_PARTICIPANT;
    }
}
