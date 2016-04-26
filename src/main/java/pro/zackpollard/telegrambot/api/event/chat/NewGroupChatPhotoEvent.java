package pro.zackpollard.telegrambot.api.event.chat;

import pro.zackpollard.telegrambot.api.chat.GroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.PhotoContent;
import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;
import pro.zackpollard.telegrambot.api.event.chat.message.MessageEvent;

/**
 * @author Zack Pollard
 */
public class NewGroupChatPhotoEvent extends MessageEvent {

    public NewGroupChatPhotoEvent(Message message) {
        super(message);
    }

    @Override
    public GroupChat getChat() {

        return (GroupChat) getMessage().getChat();
    }

    public PhotoSize[] getContent() {

        return ((PhotoContent) getMessage().getContent()).getContent();
    }
}
