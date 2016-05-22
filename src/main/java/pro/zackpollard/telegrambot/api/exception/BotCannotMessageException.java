package pro.zackpollard.telegrambot.api.exception;

/**
 * Called when the bot is unable to message a Chat or User
 *
 * @author stuntguy3000
 */
public class BotCannotMessageException extends TelegramApiException {
    public BotCannotMessageException(String description) {
        super(description, 403);
    }
}
