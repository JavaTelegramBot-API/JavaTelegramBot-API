package org.telegram.botapi.api.chat;

import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.send.SendableMessage;
import org.telegram.botapi.api.chat.message.send.SendableTextMessage;

/**
 * @author Zack Pollard
 */
public interface Chat {

    int getId();

    default Message sendMessage(String message) {

        return this.sendMessage(SendableTextMessage.builder().message(message).build());
    }

    Message sendMessage(SendableMessage message);
}