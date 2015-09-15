package org.telegram.botapi.api.chat.message.content;

import org.telegram.botapi.api.chat.message.content.type.Location;

/**
 * @author Zack Pollard
 */
public interface LocationContent extends Content {

	Location getContent();

	@Override
	default ContentType getType() {

		return ContentType.LOCATION;
	}
}
