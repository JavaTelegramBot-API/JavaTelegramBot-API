package org.telegram.javabotapi.api.chat.message;

/**
 * @author Zack Pollard
 */
public interface ForceReply {

    default boolean getForceReply() {

        return true;
    }
}
