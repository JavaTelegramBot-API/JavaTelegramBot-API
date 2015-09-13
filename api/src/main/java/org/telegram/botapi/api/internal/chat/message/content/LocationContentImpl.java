package org.telegram.botapi.api.internal.chat.message.content;

import org.json.JSONObject;
import org.telegram.botapi.api.chat.message.content.LocationContent;
import org.telegram.botapi.api.chat.message.content.type.Location;
import org.telegram.botapi.api.internal.chat.message.content.type.LocationImpl;

/**
 * @author Zack Pollard
 */
public class LocationContentImpl implements LocationContent {

	private final Location content;

	private LocationContentImpl(JSONObject jsonObject) {

		this.content = LocationImpl.createLocation(jsonObject);
	}

	public static LocationContent createLocationContent(JSONObject jsonObject) {

		return jsonObject != null ? new LocationContentImpl(jsonObject) : null;
	}

	@Override
	public Location getContent() {
		return content;
	}
}
