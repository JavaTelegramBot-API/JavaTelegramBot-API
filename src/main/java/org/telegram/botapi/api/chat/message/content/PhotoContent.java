package org.telegram.botapi.api.chat.message.content;

import org.telegram.botapi.api.chat.message.content.type.PhotoSize;

/**
 * @author Zack Pollard
 */
public interface PhotoContent extends Content, Captionable {

	PhotoSize[] getContent();

	@Override
	default ContentType getType() {

		return ContentType.PHOTO;
	}
}