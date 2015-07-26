package org.telegram.botapi.api.chat.message;

/**
 * @author Zack Pollard
 */
public interface ForceReply {

    default boolean getForceReply() {

        return true;
    }
}
