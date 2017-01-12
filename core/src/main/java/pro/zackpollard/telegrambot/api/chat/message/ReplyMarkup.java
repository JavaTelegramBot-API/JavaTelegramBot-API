package pro.zackpollard.telegrambot.api.chat.message;

/**
 * @author Zack Pollard
 */
public interface ReplyMarkup {

    /**
     * Gets the ReplyMarkupType for this ReplyMarkup object
     *
     * @return The ReplyMarkupType for this ReplyMarkup object
     */
    ReplyMarkupType getType();
}
