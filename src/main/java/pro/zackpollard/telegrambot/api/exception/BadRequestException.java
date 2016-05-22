package pro.zackpollard.telegrambot.api.exception;

/**
 * Called when a bad request is made
 * <p>This can include a range of items, such as a Chat is not found or </p>
 *
 * @author stuntguy3000
 */
public class BadRequestException extends TelegramApiException {
    public BadRequestException(String description) {
        super(description, 400);
    }
}
