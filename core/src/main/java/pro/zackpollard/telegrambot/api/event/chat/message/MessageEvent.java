package pro.zackpollard.telegrambot.api.event.chat.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.event.Cancellable;
import pro.zackpollard.telegrambot.api.event.Event;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor
public abstract class MessageEvent implements Event, Cancellable {

    private final Message message;

    @Getter
    @Setter
    private boolean cancelled;

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
