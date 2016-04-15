package pro.zackpollard.telegrambot.api.keyboards;

import lombok.NonNull;

/**
 * @author zackp
 */

public class KeyboardButton {

    @NonNull
    private final String text;
    private final boolean request_contact;
    private final boolean request_location;

    @java.beans.ConstructorProperties({"text", "request_contact", "request_location"})
    private KeyboardButton(String text, boolean request_contact, boolean request_location) {
        this.text = text;
        this.request_contact = request_contact;
        this.request_location = request_location;
    }

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
            return this;
        }

        public KeyboardButton.KeyboardButtonBuilder requestLocation(boolean requestLocation) {
            this.request_location = requestLocation;
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
