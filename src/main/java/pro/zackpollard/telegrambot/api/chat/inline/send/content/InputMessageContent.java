package pro.zackpollard.telegrambot.api.chat.inline.send.content;

/**
 * @author zackp
 */
public interface InputMessageContent {

    /**
     * Gets the type of InputMessageContent that this object represents
     *
     * @return The InputMessageContentType of this object
     */
    InputMessageContentType getType();
}
