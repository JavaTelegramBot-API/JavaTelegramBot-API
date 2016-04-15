package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.Message;

/**
 * @author Zack Pollard
 */
public interface PinnedMessageContent extends Content {

    Message getContent();

    @Override
    default ContentType getType() {

        return ContentType.PINNED_MESSAGE;
    }
}
