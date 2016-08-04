package pro.zackpollard.telegrambot.api.chat.inline.send.content;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author zackp
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InputVenueMessageContent implements InputMessageContent {

    @NonNull
    private final double latitude;
    @NonNull
    private final double longitude;
    @NonNull
    private final String title;
    @NonNull
    private final String address;
    private final String foursquare_id;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InputVenueMessageContentBuilder object used to construct the InputVenueMessageContent object
     */
    public static InputVenueMessageContentBuilder builder() {
        return new InputVenueMessageContentBuilder();
    }

    /**
     * Gets latitude of the venue
     *
     * @return The latitude of the venue
     */
    @NonNull
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Gets longitude of the venue
     *
     * @return The longitude of the venue
     */
    @NonNull
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Gets the title of the venue
     *
     * @return The title of the venue
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
     * Gets the Foursquare ID for the venue
     *
     * @return The Foursquare ID for the venue
     */
    public String getFoursquareId() {
        return this.foursquare_id;
    }

    /**
     * Gets the type of InputMessageContent that this object represents
     *
     * @return The InputMessageContentType of this object
     */
    @Override
    public InputMessageContentType getType() {
        return InputMessageContentType.VENUE;
    }

    /**
     * The builder for the InputVenueMessageContent object
     */
    @ToString
    public static class InputVenueMessageContentBuilder {

        private double latitude;
        private double longitude;
        private String title;
        private String address;
        private String foursquare_id;

        InputVenueMessageContentBuilder() {
        }

        /**
         * *Required*
         * Sets the latitude to the provided value
         *
         * @param latitude The latitude of the venue
         *
         * @return The builder object
         */
        public InputVenueMessageContent.InputVenueMessageContentBuilder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * *Required*
         * Sets the longitude to the provided value
         *
         * @param longitude The longitude of the venue
         *
         * @return The builder object
         */
        public InputVenueMessageContent.InputVenueMessageContentBuilder longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * *Required*
         * Sets the title to the provided value
         *
         * @param title The title of the venue
         *
         * @return The builder object
         */
        public InputVenueMessageContent.InputVenueMessageContentBuilder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * *Required*
         * Sets the address to the provided value
         *
         * @param address The address of the venue
         *
         * @return The builder object
         */
        public InputVenueMessageContent.InputVenueMessageContentBuilder address(String address) {
            this.address = address;
            return this;
        }

        /**
         * *Optional*
         * Sets the Foursquare ID for the venue
         *
         * @param foursquareId The foursquare ID for the venue
         *
         * @return The builder object
         */
        public InputVenueMessageContent.InputVenueMessageContentBuilder foursquareId(String foursquareId) {
            this.foursquare_id = foursquareId;
            return this;
        }

        /**
         * Builds the InputVenueMessageContent object
         *
         * @return An InputVenueMessageContent object based on the previously provided values
         */
        public InputVenueMessageContent build() {
            return new InputVenueMessageContent(latitude, longitude, title, address, foursquare_id);
        }
    }
}
