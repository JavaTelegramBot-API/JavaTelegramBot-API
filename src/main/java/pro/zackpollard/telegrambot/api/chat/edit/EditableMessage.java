package pro.zackpollard.telegrambot.api.chat.edit;

/**
 * @author Zack Pollard
 */
public interface EditableMessage {

    /**
     * Gets the MessageType of this SendableMessage object
     *
     * @return The MessageType of this object
     */
    EditType getType();
}
