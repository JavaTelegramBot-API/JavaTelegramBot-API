package pro.zackpollard.telegrambot.api.chat.message.send;

import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
public interface ReplyingOptions {

    int getReplyTo();

    ReplyMarkup getReplyMarkup();
}
