package pro.zackpollard.telegrambot.api.event.chat;

import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.LeftChatParticipantContent;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageEvent;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public class ParticipantLeaveGroupChatEvent extends MessageEvent {

    public ParticipantLeaveGroupChatEvent(Message message) {
        super(message);
    }

    public User getParticipant() {

        return ((LeftChatParticipantContent) getMessage().getContent()).getContent();
    }

    public Chat getChat() {

        return getMessage().getChat();
    }
}
