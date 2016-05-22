package pro.zackpollard.telegrambot.api.exception;

/**
 * @author stuntguy3000
 */
public class InvalidContentTypeException extends BadRequestException {
    public InvalidContentTypeException(String errorDescription) {
        super(errorDescription);
    }
}
