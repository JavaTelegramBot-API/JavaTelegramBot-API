package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Sticker;

/**
 * @author Zack Pollard
 */
public interface StickerContent extends Content {

	Sticker getContent();

	@Override
	default ContentType getType() {

		return ContentType.STICKER;
	}
}
