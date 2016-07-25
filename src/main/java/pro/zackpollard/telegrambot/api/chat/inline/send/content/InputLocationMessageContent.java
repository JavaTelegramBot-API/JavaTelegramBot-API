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

    @NonNull
    public double getLatitude() {
        return this.latitude;
    }

    @NonNull
    public double getLongitude() {
        return this.longitude;
    }

    @Override
    public InputMessageContentType getType() {
        return InputMessageContentType.LOCATION;
    }

    @ToString
    public static class InputLocationMessageContentBuilder {

        private double latitude;
        private double longitude;

        InputLocationMessageContentBuilder() {
        }

        public InputLocationMessageContent.InputLocationMessageContentBuilder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public InputLocationMessageContent.InputLocationMessageContentBuilder longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public InputLocationMessageContent build() {
            return new InputLocationMessageContent(latitude, longitude);
        }
    }
}
