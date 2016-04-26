package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Video;

/**
 * @author Zack Pollard
 */
public interface VideoContent extends Content, Captionable {

    Video getContent();

    @Override
    default ContentType getType() {

        return ContentType.VIDEO;
    }
}
