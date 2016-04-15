package pro.zackpollard.telegrambot.api.internal.chat.message.content.type;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Location;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Venue;

/**
 * @author Zack Pollard
 */
public class VenueImpl implements Venue {

	private final Location location;
	private final String title;
	private final String address;
	private final String foursquare_id;

	private VenueImpl(JSONObject jsonObject) {

		this.location = LocationImpl.createLocation(jsonObject.getJSONObject("location"));
		this.title = jsonObject.getString("title");
		this.address = jsonObject.getString("address");
		this.foursquare_id = jsonObject.optString("foursquare_id");
	}

	public static Venue createVenue(JSONObject jsonObject) {

		return jsonObject != null ? new VenueImpl(jsonObject) : null;
	}

	@Override
	public Location getLocation() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}

	@Override
	public String getAddress() {
		return null;
	}

	@Override
	public String getFoursquareId() {
		return null;
	}
}
