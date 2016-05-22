package pro.zackpollard.telegrambot.api.exception;

/**
 * Represents when a Chat is not found
 * <p>The error code is the same as in BadRequestException</p>
 *
 * @author stuntguy3000
 */
public class ChatNotFoundException extends BadRequestException {
    public ChatNotFoundException(String description) {
        super(description);
    }
}
