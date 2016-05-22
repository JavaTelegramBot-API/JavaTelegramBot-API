package pro.zackpollard.telegrambot.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents an API Error
 * @author stuntguy3000
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public abstract class TelegramApiException extends Exception {
    private String errorDescription;
    private int errorCode;
}
