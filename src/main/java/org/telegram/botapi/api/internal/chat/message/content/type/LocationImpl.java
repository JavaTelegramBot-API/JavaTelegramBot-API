package org.telegram.botapi.api.internal.chat.message.content.type;

import org.json.JSONObject;
import org.telegram.botapi.api.chat.message.content.type.Location;

/**
 * @author Zack Pollard
 */
public class LocationImpl implements Location {

	private final double longitude;
	private final double latitude;

	private LocationImpl(JSONObject jsonObject) {

		this.longitude = jsonObject.getDouble("longitude");
		this.latitude = jsonObject.getDouble("latitude");
	}

	public static Location createLocation(JSONObject jsonObject) {

		return jsonObject != null ? new LocationImpl(jsonObject) : null;
	}

	@Override
	public double getLongitude() {
		return longitude;
	}

	@Override
	public double getLatitude() {
		return latitude;
	}
}