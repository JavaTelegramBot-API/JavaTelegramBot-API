package pro.zackpollard.telegrambot.api.exception;

/**
 * Represents when a message is unable to be parsed
 * <p>The error code is the same as in BadRequestException</p>
 *
 * @author stuntguy3000
 */
public class InvalidMessageException extends BadRequestException {
    public InvalidMessageException(String description) {
        super(description);
    }
}
