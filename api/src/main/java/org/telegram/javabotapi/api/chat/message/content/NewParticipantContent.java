package org.telegram.javabotapi.api.chat.message.content;

import org.telegram.javabotapi.api.user.User;

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
