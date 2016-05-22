package pro.zackpollard.telegrambot.api.exception;

/**
 * Represents when the API response is unknown
 *
 * @author stuntguy3000
 */
public class UnknownErrorException extends TelegramApiException {

    public UnknownErrorException(String errorDescription, int errorCode) {
        super(errorDescription, errorCode);
    }
}
