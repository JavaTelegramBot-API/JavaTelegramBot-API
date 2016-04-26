package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.VenueContent;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Venue;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.VenueImpl;

/**
 * @author zackp
 */
public class VenueContentImpl implements VenueContent {

    private final Venue content;

    private VenueContentImpl(JSONObject jsonObject) {

        this.content = VenueImpl.createVenue(jsonObject);
    }

    public static VenueContent createVenueContent(JSONObject jsonObject) {

        return jsonObject != null ? new VenueContentImpl(jsonObject) : null;
    }

    @Override
    public Venue getContent() {
        return content;
    }
}
