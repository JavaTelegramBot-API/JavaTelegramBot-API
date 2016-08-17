package pro.zackpollard.telegrambot.api.chat.message.send;

/**
 * @author Zack Pollard
 */

public interface SendableMessage {

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
    MessageType getType();
}