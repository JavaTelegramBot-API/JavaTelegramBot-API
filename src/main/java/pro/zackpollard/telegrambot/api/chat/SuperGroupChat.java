package pro.zackpollard.telegrambot.api.chat;

import pro.zackpollard.telegrambot.api.exception.TelegramApiException;

/**
 * @author Zack Pollard
 */
public interface SuperGroupChat extends GroupChat {

    default ChatType getType() {

        return ChatType.SUPERGROUP;
    }

    boolean kickChatMember(int userId) throws TelegramApiException;

    boolean unbanChatMember(int userId) throws TelegramApiException;
}
