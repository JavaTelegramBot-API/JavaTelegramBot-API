package pro.zackpollard.telegrambot.api.chat;

import pro.zackpollard.telegrambot.api.exception.TelegramApiException;

/**
 * @author Zack Pollard
 */
public interface GroupChat extends Chat {

    default ChatType getType() {

        return ChatType.GROUP;
    }

    boolean kickChatMember(int userId) throws TelegramApiException;
}