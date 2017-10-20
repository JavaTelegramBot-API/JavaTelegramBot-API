package pro.zackpollard.telegrambot.api.chat.message.content.type;

import pro.zackpollard.telegrambot.api.stickers.MaskPosition;

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

    /**
     * Name of the sticker set to which the sticker belongs, can be null
     *
     * @return Name of the sticker set to which the sticker belongs or null if the set was not returned
     */
    String getSetName();

    /**
     * For mask stickers, the position where the mask should be placed, can be null
     *
     * @return The position where the mask should be placed, or null if it isn't a mask sticker
     */
    MaskPosition getMaskPosition();
}
