package pro.zackpollard.telegrambot.api.chat.inline.send.content;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author zackp
 */
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

    public static InputVenueMessageContentBuilder builder() {
        return new InputVenueMessageContentBuilder();
    }

    @NonNull
    public double getLatitude() {
        return this.latitude;
    }

    @NonNull
    public double getLongitude() {
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

    @Override
    public InputMessageContentType getType() {
        return InputMessageContentType.VENUE;
    }

    public static class InputVenueMessageContentBuilder {

        private double latitude;
        private double longitude;
        private String title;
        private String address;
        private String foursquare_id;

        InputVenueMessageContentBuilder() {
        }

        public InputVenueMessageContent.InputVenueMessageContentBuilder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public InputVenueMessageContent.InputVenueMessageContentBuilder longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public InputVenueMessageContent.InputVenueMessageContentBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InputVenueMessageContent.InputVenueMessageContentBuilder address(String address) {
            this.address = address;
            return this;
        }

        public InputVenueMessageContent.InputVenueMessageContentBuilder foursquareId(String foursquareId) {
            this.foursquare_id = foursquareId;
            return this;
        }

        public InputVenueMessageContent build() {
            return new InputVenueMessageContent(latitude, longitude, title, address, foursquare_id);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.inline.send.content.InputVenueMessageContent.InputVenueMessageContentBuilder(latitude=" + this.latitude + ", longitude=" + this.longitude + ", title=" + this.title + ", address=" + this.address + ", foursquare_id=" + this.foursquare_id + ")";
        }
    }
}
