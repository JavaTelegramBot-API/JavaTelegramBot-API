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
public class InputContactMessageContent implements InputMessageContent {

    @NonNull
    private final String phone_number;
    @NonNull
    private final String first_name;
    private final String last_name;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InputContactMessageContentBuilder object used to construct the InputContactMessageContent object
     */
    public static InputContactMessageContentBuilder builder() {
        return new InputContactMessageContentBuilder();
    }

    /**
     * Gets the type of InputMessageContent that this object represents
     *
     * @return The InputMessageContentType of this object
     */
    @Override
    public InputMessageContentType getType() {
        return InputMessageContentType.CONTACT;
    }

    /**
     * Gets contacts phone number
     *
     * @return The contacts phone number
     */
    @NonNull
    public String getPhoneNumber() {
        return this.phone_number;
    }

    /**
     * Gets contacts first name
     *
     * @return The contacts first name
     */
    @NonNull
    public String getFirstName() {
        return this.first_name;
    }

    /**
     * Gets contacts last name
     *
     * @return The contacts last name or Null
     */
    public String getLastName() {
        return this.last_name;
    }

    /**
     * The builder for the InputContactMessageContent object
     */
    @ToString
    public static class InputContactMessageContentBuilder {

        private String phone_number;
        private String first_name;
        private String last_name;

        InputContactMessageContentBuilder() {
        }

        /**
         * *Required*
         * Sets the phone number to the provided value
         *
         * @param phoneNumber The contacts phone number
         *
         * @return The builder object
         */
        public InputContactMessageContent.InputContactMessageContentBuilder phoneNumber(String phoneNumber) {
            this.phone_number = phoneNumber;
            return this;
        }

        /**
         * *Required*
         * Sets the first name to the provided value
         *
         * @param firstName The contacts first name
         *
         * @return The builder object
         */
        public InputContactMessageContent.InputContactMessageContentBuilder firstName(String firstName) {
            this.first_name = firstName;
            return this;
        }

        /**
         * *Optional*
         * Sets the last name to the provided value
         *
         * @param lastName The contacts last name
         *
         * @return The builder object
         */
        public InputContactMessageContent.InputContactMessageContentBuilder lastName(String lastName) {
            this.last_name = lastName;
            return this;
        }

        /**
         * Builds the InputContactMessageContent object
         *
         * @return An InputContactMessageContent object based on the previously provided values
         */
        public InputContactMessageContent build() {
            return new InputContactMessageContent(phone_number, first_name, last_name);
        }
    }
}
