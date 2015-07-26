package org.telegram.botapi.api.internal;

import org.telegram.botapi.api.chat.message.Message;

/**
 * @author Zack Pollard
 */
public interface Update {

    int getId();

    Message getMessage();
}
