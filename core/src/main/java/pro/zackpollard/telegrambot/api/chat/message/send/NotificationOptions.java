package pro.zackpollard.telegrambot.api.chat.message.send;

/**
 * @author Zack Pollard
 */
public interface NotificationOptions {

    /**
     * Gets whether notifications are disabled for this message
     *
     * @return True if notifications are disabled, otherwise False
     */
    boolean isDisableNotification();
}