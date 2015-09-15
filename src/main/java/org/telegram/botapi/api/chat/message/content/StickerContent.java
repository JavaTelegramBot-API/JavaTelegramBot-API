package org.telegram.botapi.api.chat.message.content;

import org.telegram.botapi.api.chat.message.content.type.Sticker;

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
