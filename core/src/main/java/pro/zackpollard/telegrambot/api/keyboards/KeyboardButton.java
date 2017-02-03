package pro.zackpollard.telegrambot.api.keyboards;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author zackp
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class KeyboardButton {

    @NonNull
    private final String text;
    private final boolean request_contact;
    private final boolean request_location;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A KeyboardButtonBuilder object used to construct the KeyboardButton object
     */
    public static KeyboardButtonBuilder builder() {
        return new KeyboardButtonBuilder();
    }

    /**
     * Gets the text that this KeyboardButton will have
     *
     * @return The text that this KeyboardButton will have
     */
    public String getText() {
        return this.text;
    }

    /**
     * Gets whether the users contact should be sent when the button is pressed. If True, the user's phone number will
     * be sent as a contact when the button is pressed. Available in private chats only
     *
     * @return True if the users contact should be sent, otherwise False
     */
    public boolean isRequestContact() {
        return this.request_contact;
    }

    /**
     * Gets whether the users location should be sent when the button is pressed.  If True, the user's current location
     * will be sent when the button is pressed. Available in private chats only
     *
     * @return True if the users location should be sent, otherwise False
     */
    public boolean isRequestLocation() {
        return this.request_location;
    }

    @ToString
    public static class KeyboardButtonBuilder {
        private String text;
        private boolean request_contact = false;
        private boolean request_location = false;

        KeyboardButtonBuilder() {
        }

        /**
         * *Required*
         * Sets the text that will be displayed on this button
         *
         * @param text The text that will be displayed on this button
         *
         * @return The builder object
         */
        public KeyboardButton.KeyboardButtonBuilder text(String text) {
            this.text = text;
            return this;
        }

        /**
         * *Optional*
         * Sets whether the button should request the users contact information when clicked
         *
         * @param requestContact True will set the button to request the contact information, False is the default
         *
         * @return The builder object
         */
        public KeyboardButton.KeyboardButtonBuilder requestContact(boolean requestContact) {
            this.request_contact = requestContact;
            if(requestContact) this.request_location = false;
            return this;
        }

        /**
         * *Optional*
         * Sets whether the button should request the users location information when clicked
         *
         * @param requestLocation True will set the button to request the location information, False is the default
         *
         * @return The builder object
         */
        public KeyboardButton.KeyboardButtonBuilder requestLocation(boolean requestLocation) {
            this.request_location = requestLocation;
            if(requestLocation) this.request_contact = false;
            return this;
        }

        /**
         * Builds the KeyboardButton object
         *
         * @return A KeyboardButton object based on the previously provided values
         */
        public KeyboardButton build() {
            return new KeyboardButton(text, request_contact, request_location);
        }
    }
}
