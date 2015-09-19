package pro.zackpollard.telegrambot.api.updates;

import pro.zackpollard.telegrambot.api.chat.message.Message;

/**
 * @author Zack Pollard
 */
public interface Update {

	int getId();

	Message getMessage();
}
