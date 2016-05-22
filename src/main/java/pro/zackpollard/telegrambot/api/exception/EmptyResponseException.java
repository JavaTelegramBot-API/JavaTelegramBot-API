package pro.zackpollard.telegrambot.api.exception;

/**
 * Represents when the API response is empty or null
 *
 * @author stuntguy3000
 */
public class EmptyResponseException extends TelegramApiException {

    public EmptyResponseException(String errorDescription) {
        super(errorDescription, -1);
    }
}
