package org.telegram.javabotapi.api.chat;

/**
 * @author Zack Pollard
 */
public interface GroupChat extends Chat {

    String getName();

    void leave();
}