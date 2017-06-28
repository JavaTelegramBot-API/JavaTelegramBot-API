package pro.zackpollard.telegrambot.api.event.chat;

import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.NewChatParticipantContent;
import pro.zackpollard.telegrambot.api.chat.message.content.NewChatParticipantsContent;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageEvent;
import pro.zackpollard.telegrambot.api.user.User;

import java.util.Set;

/**
 * @author Zack Pollard
 */
public class ParticipantsJoinGroupChatEvent extends MessageEvent {

    public ParticipantsJoinGroupChatEvent(Message message) {
        super(message);
    }

    /**
     * Gets the Users that joined the GroupChat that triggered this Event
     *
     * @return The Users that joined the GroupChat that triggered this Event
     */
    public Set<User> getParticipants() {

        return ((NewChatParticipantsContent) getMessage().getContent()).getContent();
    }

    /**
     * Gets the Chat that the Users joined that triggered this Event
     *
     * @return The Chat that the Users joined that triggered this Event
     */
    public Chat getChat() {

        return getMessage().getChat();
    }
}
