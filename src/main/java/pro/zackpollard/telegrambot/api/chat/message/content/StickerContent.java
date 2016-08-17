package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Sticker;

/**
 * @author Zack Pollard
 */
public interface StickerContent extends Content {

    /**
     * Gets the Sticker object relating to this StickerContent object
     *
     * @return The Sticker object
     */
    Sticker getContent();

    /**
     * Gets the ContentType relating to this Content object
     *
     * @return The ContentType of this Content object
     */
    @Override
    default ContentType getType() {

        return ContentType.STICKER;
    }
}
