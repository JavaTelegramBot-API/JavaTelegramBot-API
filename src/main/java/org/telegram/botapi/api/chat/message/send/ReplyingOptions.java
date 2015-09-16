package org.telegram.botapi.api.chat.message.send;

import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
public interface ReplyingOptions {

	Message getReplyTo();

	ReplyMarkup getReplyMarkup();
}
