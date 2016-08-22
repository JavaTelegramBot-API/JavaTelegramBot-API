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

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultVenueBuilder object used to construct the InlineQueryResultVenue object
     */
    public static InlineQueryResultVenueBuilder builder() {
        return new InlineQueryResultVenueBuilder();
    }

    /**
     * Get the type of InlineQueryResult that this object refers to
     *
     * @return The InlineQueryResultType for this object
     */
    @Override
    public InlineQueryResultType getType() {
        return this.type;
    }

    /**
     * Gets the ID of this InlineQueryResult object
     *
     * @return The ID of this result
     */
    @NonNull
    public String getId() {
        return this.id;
    }

    /**
     * Gets the latitude of the venue
     *
     * @return The latitude of the venue
     */
    @NonNull
    public Double getLatitude() {
        return this.latitude;
    }

    /**
     * Gets the longitude of the venue
     *
     * @return The longitude of the venue
     */
    @NonNull
    public Double getLongitude() {
        return this.longitude;
    }

    /**
     * Gets the title of the result
     *
     * @return The title of the result
     */
    @NonNull
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the address of the venue
     *
     * @return The address of the venue
     */
    @NonNull
    public String getAddress() {
        return this.address;
    }

    /**
     * Gets the foursquare ID for the venue
     *
     * @return The foursquare ID for the venue
     */
    public String getFoursquareId() {
        return this.foursquare_id;
    }

    /**
     * Gets the inline keyboard attached to this message
     *
     * @return The inline keyboard attached to this message
     */
    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
    }

    /**
     * Gets the content of the message to be sent instead of the venue
     *
     * @return The content of the message to be sent instead of the venue
     */
    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    /**
     * Gets the URL of the thumbnail for the result
     *
     * @return The URL of the thumbnail for the result
     */
    public URL getThumbUrl() {
        return this.thumb_url;
    }

    /**
     * Gets the width of the thumbnail in pixels
     *
     * @return The width of the thumbnail in pixels
     */
    public int getThumbWidth() {
        return this.thumb_width;
    }

    /**
     * Gets the height of the thumbnail in pixels
     *
     * @return The height of the thumbnail in pixels
     */
    public int getThumbHeight() {
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

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultVenue.InlineQueryResultVenueBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the latitude of the venue for the result
         *
         * @param latitude The latitude for the venue
         *
         * @return The builder object
         */
        public InlineQueryResultVenue.InlineQueryResultVenueBuilder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * *Required*
         * Sets the longitude of the venue for the result
         *
         * @param longitude The longitude of the venue
         *
         * @return The builder object
         */
        public InlineQueryResultVenue.InlineQueryResultVenueBuilder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * *Required*
         * Sets the title to the provided value
         *
         * @param title The title you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultVenue.InlineQueryResultVenueBuilder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * *Required*
         * Sets the address of the venue to the provided value
         *
         * @param address The address of the venue
         *
         * @return The builder object
         */
        public InlineQueryResultVenue.InlineQueryResultVenueBuilder address(String address) {
            this.address = address;
            return this;
        }

        /**
         * *Optional*
         * Sets the foursquare ID of the venue to the provided value
         *
         * @param foursquareId The foursquare ID of the venue
         *
         * @return The builder object
         */
        public InlineQueryResultVenue.InlineQueryResultVenueBuilder foursquareId(String foursquareId) {
            this.foursquare_id = foursquareId;
            return this;
        }

        /**
         * *Optional*
         * Sets the inline keyboard attached to this message to the InlineReplyMarkup provided
         *
         * @param replyMarkup The inline keyboard you want to attach to the message
         *
         * @return The builder object
         */
        public InlineQueryResultVenue.InlineQueryResultVenueBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        /**
         * *Optional*
         * Sets the content you want to be sent with this result to the provided InputMessageContent object
         *
         * @param inputMessageContent The content you want to be sent with the result
         *
         * @return The builder object
         */
        public InlineQueryResultVenue.InlineQueryResultVenueBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * *Optional*
         * Sets the URL of the thumbnail that should show next to the result in the inline result selection pane
         *
         * @param thumbUrl The URL of the thumbnail you want to be shown next to the result in the result selection pane
         *
         * @return The builder object
         */
        public InlineQueryResultVenue.InlineQueryResultVenueBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        /**
         * *Optional*
         * Sets the width of the thumbnail at the previously provided URL through {@link #thumbUrl(URL)}
         *
         * @param thumbWidth The width of the thumbnail
         *
         * @return The builder object
         */
        public InlineQueryResultVenue.InlineQueryResultVenueBuilder thumbWidth(int thumbWidth) {
            this.thumb_width = thumbWidth;
            return this;
        }

        /**
         * *Optional*
         * Sets the height of the thumbnail at the previously provided URL through {@link #thumbUrl(URL)}
         *
         * @param thumbHeight The height of the thumbnail
         *
         * @return The builder object
         */
        public InlineQueryResultVenue.InlineQueryResultVenueBuilder thumbHeight(int thumbHeight) {
            this.thumb_height = thumbHeight;
            return this;
        }

        /**
         * Builds the InlineQueryResultVenue object
         *
         * @return An InlineQueryResultVenue object based on the previously provided values
         */
        public InlineQueryResultVenue build() {
            return new InlineQueryResultVenue(id, latitude, longitude, title, address, foursquare_id, reply_markup, input_message_content, thumb_url, thumb_width, thumb_height);
        }
    }
}
