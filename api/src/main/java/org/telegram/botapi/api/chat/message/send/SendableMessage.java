package org.telegram.botapi.api.chat.message.send;

import org.telegram.botapi.api.chat.Chat;
import org.telegram.botapi.api.chat.message.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Zack Pollard
 */

public interface SendableMessage {

    MessageType getType();
}