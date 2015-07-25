package org.telegram.javabotapi.api.internal;

import org.telegram.javabotapi.api.chat.message.Message;

/**
 * @author Zack Pollard
 */
public interface Update {

    int getId();

    Message getMessage();
}
