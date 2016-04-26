package pro.zackpollard.telegrambot.api.chat.inline.send.results;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.InlineReplyMarkup;
import pro.zackpollard.telegrambot.api.chat.inline.send.content.InputMessageContent;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.net.URL;

/**
 * @author zackp
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineQueryResultVenue implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.VENUE;
    @NonNull
    private final String id;
    @NonNull
    private final Double latitude;
    @NonNull
    private final Double longitude;
    @NonNull
    private final String title;
    @NonNull
    private final String address;
    private final String foursquare_id;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;
    private final URL thumb_url;
    private final Integer thumb_width;
    private final Integer thumb_height;

    public static InlineQueryResultVenueBuilder builder() {
        return new InlineQueryResultVenueBuilder();
    }

    @Override
    public InlineQueryResultType getType() {
        return this.type;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @NonNull
    public Double getLatitude() {
        return this.latitude;
    }

    @NonNull
    public Double getLongitude() {
        return this.longitude;
    }

    @NonNull
    public String getTitle() {
        return this.title;
    }

    @NonNull
    public String getAddress() {
        return this.address;
    }

    public String getFoursquareId() {
        return this.foursquare_id;
    }

    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
    }

    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    public URL getThumbUrl() {
        return this.thumb_url;
    }

    public Integer getThumbWidth() {
        return this.thumb_width;
    }

    public Integer getThumbHeight() {
        return this.thumb_height;
    }

    @ToString
    public static class InlineQueryResultVenueBuilder {
        private String id = Utils.generateRandomString(32);
        private Double latitude;
        private Double longitude;
        private String title;
        private String address;
        private String foursquare_id;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;
        private URL thumb_url;
        private Integer thumb_width;
        private Integer thumb_height;

        InlineQueryResultVenueBuilder() {
        }

        public InlineQueryResultVenue.InlineQueryResultVenueBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultVenue.InlineQueryResultVenueBuilder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public InlineQueryResultVenue.InlineQueryResultVenueBuilder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public InlineQueryResultVenue.InlineQueryResultVenueBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultVenue.InlineQueryResultVenueBuilder address(String address) {
            this.address = address;
            return this;
        }

        public InlineQueryResultVenue.InlineQueryResultVenueBuilder foursquareId(String foursquareId) {
            this.foursquare_id = foursquareId;
            return this;
        }

        public InlineQueryResultVenue.InlineQueryResultVenueBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        public InlineQueryResultVenue.InlineQueryResultVenueBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultVenue.InlineQueryResultVenueBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        public InlineQueryResultVenue.InlineQueryResultVenueBuilder thumbWidth(Integer thumbWidth) {
            this.thumb_width = thumbWidth;
            return this;
        }

        public InlineQueryResultVenue.InlineQueryResultVenueBuilder thumbHeight(Integer thumbHeight) {
            this.thumb_height = thumbHeight;
            return this;
        }

        public InlineQueryResultVenue build() {
            return new InlineQueryResultVenue(id, latitude, longitude, title, address, foursquare_id, reply_markup, input_message_content, thumb_url, thumb_width, thumb_height);
        }
    }
}
