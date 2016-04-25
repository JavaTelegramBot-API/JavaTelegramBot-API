package pro.zackpollard.telegrambot.api.chat.inline.send.content;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author zackp
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InputContactMessageContent implements InputMessageContent {

    @NonNull
    private final String phone_number;
    @NonNull
    private final String first_name;
    private final String last_name;

    public static InputContactMessageContentBuilder builder() {
        return new InputContactMessageContentBuilder();
    }

    @Override
    public InputMessageContentType getType() {
        return InputMessageContentType.CONTACT;
    }

    @NonNull
    public String getPhoneNumber() {
        return this.phone_number;
    }

    @NonNull
    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public static class InputContactMessageContentBuilder {

        private String phone_number;
        private String first_name;
        private String last_name;

        InputContactMessageContentBuilder() {
        }

        public InputContactMessageContent.InputContactMessageContentBuilder phoneNumber(String phoneNumber) {
            this.phone_number = phoneNumber;
            return this;
        }

        public InputContactMessageContent.InputContactMessageContentBuilder firstName(String firstName) {
            this.first_name = firstName;
            return this;
        }

        public InputContactMessageContent.InputContactMessageContentBuilder lastName(String lastName) {
            this.last_name = lastName;
            return this;
        }

        public InputContactMessageContent build() {
            return new InputContactMessageContent(phone_number, first_name, last_name);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.inline.send.content.InputContactMessageContent.InputContactMessageContentBuilder(phone_number=" + this.phone_number + ", first_name=" + this.first_name + ", last_name=" + this.last_name + ")";
        }
    }
}
