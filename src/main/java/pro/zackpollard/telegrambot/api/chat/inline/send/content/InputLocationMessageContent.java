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
public class InputLocationMessageContent implements InputMessageContent {

    @NonNull
    private final double latitude;
    @NonNull
    private final double longitude;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InputLocationMessageContentBuilder object used to construct the InputLocationMessageContent object
     */
    public static InputLocationMessageContentBuilder builder() {
        return new InputLocationMessageContentBuilder();
    }

    /**
     * Gets the latitude of the location
     *
     * @return The latitude of the location
     */
    @NonNull
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Gets the longitude of the location
     *
     * @return The longitude for the location
     */
    @NonNull
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Gets the type of InputMessageContent that this object represents
     *
     * @return The InputMessageContentType of this object
     */
    @Override
    public InputMessageContentType getType() {
        return InputMessageContentType.LOCATION;
    }

    /**
     * The builder for the InputLocationMessageContent object
     */
    @ToString
    public static class InputLocationMessageContentBuilder {

        private double latitude;
        private double longitude;

        InputLocationMessageContentBuilder() {
        }

        /**
         * *Required*
         * Sets the latitude to the provided value
         *
         * @param latitude The latitude of the location
         *
         * @return The builder object
         */
        public InputLocationMessageContent.InputLocationMessageContentBuilder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * *Required*
         * Sets the longitude to the provided value
         *
         * @param longitude The longitude of the location
         *
         * @return The builder object
         */
        public InputLocationMessageContent.InputLocationMessageContentBuilder longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * Builds the InputLocationMessageContent object
         *
         * @return An InputLocationMessageContent object based on the previously provided values
         */
        public InputLocationMessageContent build() {
            return new InputLocationMessageContent(latitude, longitude);
        }
    }
}
