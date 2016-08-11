package pro.zackpollard.telegrambot.api.event.chat.message;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.event.Event;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor
public abstract class MessageEvent implements Event {

    private final Message message;

    /**
     * Gets the Chat that this Message is related to
     *
     * @return The Chat that this message is related to
     */
    public Chat getChat() {

        return message.getChat();
    }

    /**
     * Gets the Message that was received from the Telegram Bot API that triggered this Event
     *
     * @return The Message that was received that triggered this event
     */
    public Message getMessage() {
        return this.message;
    }
}
