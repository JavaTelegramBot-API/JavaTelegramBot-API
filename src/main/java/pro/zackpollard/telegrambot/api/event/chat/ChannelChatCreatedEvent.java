package pro.zackpollard.telegrambot.api.event.chat;

import pro.zackpollard.telegrambot.api.chat.ChannelChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageEvent;

/**
 * @author Zack Pollard
 */
public class ChannelChatCreatedEvent extends MessageEvent {

    public ChannelChatCreatedEvent(Message message) {
        super(message);
    }

    /**
     * Gets the ChannelChat that was created that triggered this Event
     *
     * @return The ChannelChat that was created that triggered this Event
     */
    @Override
    public ChannelChat getChat() {

        return (ChannelChat) getMessage().getChat();
    }
}
