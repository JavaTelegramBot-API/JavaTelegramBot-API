package pro.zackpollard.telegrambot.api.chat.message.send;

import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
public interface ReplyingOptions {

    /**
     * Gets the ID of the message that you are replying to
     *
     * @return The ID of the message you are replying to
     */
    long getReplyTo();

    /**
     * The reply markup you are sending with this message
     *
     * @return The reply markup you are sending with this message
     */
    ReplyMarkup getReplyMarkup();
}
