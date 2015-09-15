package org.telegram.botapi.api.updates;

import org.telegram.botapi.api.chat.message.Message;

/**
 * @author Zack Pollard
 */
public interface Update {

	int getId();

	Message getMessage();
}
