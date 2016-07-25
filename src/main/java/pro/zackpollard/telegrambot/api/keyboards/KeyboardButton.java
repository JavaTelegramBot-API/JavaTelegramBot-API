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

    public String getText() {
        return this.text;
    }

    public boolean isRequestContact() {
        return this.request_contact;
    }

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

        public KeyboardButton.KeyboardButtonBuilder text(String text) {
            this.text = text;
            return this;
        }

        public KeyboardButton.KeyboardButtonBuilder requestContact(boolean requestContact) {
            this.request_contact = requestContact;
            if(requestContact) this.request_location = false;
            return this;
        }

        public KeyboardButton.KeyboardButtonBuilder requestLocation(boolean requestLocation) {
            this.request_location = requestLocation;
            if(requestLocation) this.request_contact = false;
            return this;
        }

        public KeyboardButton build() {
            return new KeyboardButton(text, request_contact, request_location);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.keyboards.KeyboardButton.KeyboardButtonBuilder(text=" + this.text + ", request_contact=" + this.request_contact + ", request_location=" + this.request_location + ")";
        }
    }
}
