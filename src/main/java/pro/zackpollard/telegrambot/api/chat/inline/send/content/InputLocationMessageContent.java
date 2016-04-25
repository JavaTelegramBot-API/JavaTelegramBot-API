package pro.zackpollard.telegrambot.api.chat.inline.send.content;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author zackp
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InputLocationMessageContent implements InputMessageContent {

    @NonNull
    private final double latitude;
    @NonNull
    private final double longitude;

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

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.inline.send.content.InputLocationMessageContent.InputLocationMessageContentBuilder(latitude=" + this.latitude + ", longitude=" + this.longitude + ")";
        }
    }
}
