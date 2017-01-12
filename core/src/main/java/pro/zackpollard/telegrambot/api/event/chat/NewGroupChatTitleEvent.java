package pro.zackpollard.telegrambot.api.event.chat;

import pro.zackpollard.telegrambot.api.chat.GroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageEvent;

/**
 * @author Zack Pollard
 */
public class NewGroupChatTitleEvent extends MessageEvent {

    public NewGroupChatTitleEvent(Message message) {
        super(message);
    }

    /**
     * Gets the Chat that had its title changed that triggered this Event
     *
     * @return The Chat that had its title changed that triggered this Event
     */
    @Override
    public GroupChat getChat() {

        return (GroupChat) getMessage().getChat();
    }

    /**
     * Gets the new title of the GroupChat that had its title changed
     *
     * @return The new title of the GroupChat that had its title changed
     */
    public String getTitle() {

        return getChat().getName();
    }
}
