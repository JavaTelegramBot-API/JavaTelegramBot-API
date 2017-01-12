package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Sticker extends DimensionableFile, Thumbnailable {

    /**
     * Gets the emoji that the sticker relates to, can be null
     *
     * @return The emoji that the sticker relates to or null if it doesn't have an equivalent emoji
     */
    String getEmoji();
}
