package pro.zackpollard.telegrambot.api.keyboards;

import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkupType;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zack Pollard
 */
@ToString
public class ReplyKeyboardMarkup implements Keyboard {

    private final List<List<KeyboardButton>> keyboard;
    private final boolean resize_keyboard;
    private final boolean one_time_keyboard;
    private boolean selective;

    private ReplyKeyboardMarkup(ReplyKeyboardMarkupBuilder builder) {

        this.keyboard = builder.keyboard;
        this.resize_keyboard = builder.resize_keyboard;
        this.one_time_keyboard = builder.one_time_keyboard;
        this.selective = builder.selective;
    }

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A ReplyKeyboardMarkupBuilder object used to construct the ReplyKeyboardMarkup object
     */
    public static ReplyKeyboardMarkupBuilder builder() {

        return new ReplyKeyboardMarkupBuilder();
    }

    /**
     * Gets Array of button rows, each represented by an Array of Strings
     *
     * @return Button rows
     */
    public List<List<KeyboardButton>> getButtons() {

        return keyboard;
    }

    /**
     * Gets whether the keyboard should be resized on the client for optimal vertical fit
     *
     * @return Resize option, default false
     */
    public boolean getResizeKeyboard() {

        return resize_keyboard;
    }

    /**
     * Gets whether the keyboard is one-time i.e. will vanish after it has been used
     *
     * @return One-time option, default false
     */
    public boolean getOneTime() {

        return one_time_keyboard;
    }

    /**
     * Gets whether the reply markup will only show for selected users
     * Targets: 1) users that are @mentioned in the text of the Message object;
     * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message
     *
     * @return Selective option, default false
     */
    public boolean getSelective() {
        return selective;
    }

    /**
     * Gets the ReplyMarkupType for this ReplyMarkup object
     *
     * @return The ReplyMarkupType for this ReplyMarkup object
     */
    @Override
    public ReplyMarkupType getType() {
        return ReplyMarkupType.KEYBOARD_MARKUP;
    }

    @ToString
    public static class ReplyKeyboardMarkupBuilder {

        private final List<List<KeyboardButton>> keyboard = new LinkedList<>();
        private boolean resize_keyboard = false;
        private boolean one_time_keyboard = false;
        private boolean selective = false;

        private ReplyKeyboardMarkupBuilder() {
        }

        /**
         * *Optional*
         * Add a new row to the keyboard
         *
         * @param buttons The buttons for the new row
         *
         * @return The keyboard builder
         */
        public ReplyKeyboardMarkupBuilder addRow(KeyboardButton... buttons) {

            return addRow(Arrays.asList(buttons));
        }

        /**
         * *Optional*
         * Add a new row to the keyboard
         *
         * @param buttons The buttons for the new row
         *
         * @return The keyboard builder
         */
        public ReplyKeyboardMarkupBuilder addRow(List<KeyboardButton> buttons) {

            keyboard.add(new LinkedList<>(buttons));
            return this;
        }

        /**
         * *Optional*
         * Sets a row of the keyboard
         *
         * @param row       The row you want to set the buttons for
         * @param buttons   The buttons for the row
         *
         * @return The keyboard builder
         *
         * @throws IndexOutOfBoundsException if the row is out of range
         */
        public ReplyKeyboardMarkupBuilder setRow(int row, KeyboardButton... buttons) {

            return setRow(row, Arrays.asList(buttons));
        }

        /**
         * *Optional*
         * Sets a row of the keyboard
         *
         * @param row        The index of the row
         * @param buttons    The buttons for the row
         *
         * @return The keyboard builder
         *
         * @throws IndexOutOfBoundsException if the row is out of range
         */
        public ReplyKeyboardMarkupBuilder setRow(int row, List<KeyboardButton> buttons) {

            keyboard.get(row).clear();
            keyboard.get(row).addAll(buttons);
            return this;
        }

        /**
         * *Optional*
         * Sets a cell of the keyboard
         *
         * @param row       The index of the row
         * @param column    The index of the column
         * @param button    The value for the cell
         *
         * @return The keyboard builder
         *
         * @throws IndexOutOfBoundsException if the row or column is out of range
         */
        public ReplyKeyboardMarkupBuilder setCell(int row, int column, KeyboardButton button) {

            keyboard.get(row).set(column, button);
            return this;
        }

        /**
         * *Optional*
         * Requests clients to resize the keyboard vertically for optimal fit
         * (e.g., make the keyboard smaller if there are just two rows of buttons).
         * Defaults to false, in which case the custom keyboard is always of the
         * same height as the app's standard keyboard
         *
         * @param resize Whether the client should resize the keyboard
         *
         * @return The keyboard builder
         */
        public ReplyKeyboardMarkupBuilder resize(boolean resize) {

            this.resize_keyboard = resize;
            return this;
        }

        /**
         * *Optional*
         * Requests clients to hide the keyboard as soon as it's been used.
         * Defaults to false
         *
         * @param oneTime Whether the keyboard is a one time keyboard
         *
         * @return The keyboard builder
         */
        public ReplyKeyboardMarkupBuilder oneTime(boolean oneTime) {

            this.one_time_keyboard = oneTime;
            return this;
        }

        /**
         * *Optional*
         * Use this parameter if you want to show the keyboard to specific users only.
         * Targets: 1) users that are @mentioned in the text of the Message object;
         * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message
         *
         * @param selective Whether the keyboard is a selective keyboard
         *
         * @return The keyboard builder
         */
        public ReplyKeyboardMarkupBuilder selective(boolean selective) {

            this.selective = selective;
            return this;
        }

        /**
         * Builds the ReplyKeyboardMarkup object
         *
         * @return A ReplyKeyboardMarkup object based on the previously provided values
         */
        public ReplyKeyboardMarkup build() {

            return new ReplyKeyboardMarkup(this);
        }
    }
}
