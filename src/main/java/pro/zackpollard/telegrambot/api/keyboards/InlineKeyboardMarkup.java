package pro.zackpollard.telegrambot.api.keyboards;

import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkupType;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class InlineKeyboardMarkup implements InlineKeyboard {

    private final List<List<InlineKeyboardButton>> keyboard;

    private InlineKeyboardMarkup(InlineKeyboardMarkupBuilder builder) {

        this.keyboard = builder.keyboard;
    }

    public static InlineKeyboardMarkupBuilder builder() {

        return new InlineKeyboardMarkupBuilder();
    }

    /**
     * Gets Array of button rows, each represented by an Array of Strings
     *
     * @return Button rows
     */
    public List<List<InlineKeyboardButton>> getButtons() {

        return keyboard;
    }

    @Override
    public ReplyMarkupType getType() {
        return ReplyMarkupType.INLINE_KEYBOARD_MARKUP;
    }

    public static class InlineKeyboardMarkupBuilder {

        private final List<List<InlineKeyboardButton>> keyboard = new LinkedList<>();

        private InlineKeyboardMarkupBuilder() {
        }

        /**
         * Add a new row to the keyboard
         *
         * @param buttons The buttons for the new row
         * @return The keyboard builder
         */
        public InlineKeyboardMarkupBuilder addRow(InlineKeyboardButton... buttons) {

            return addRow(Arrays.asList(buttons));
        }

        /**
         * Add a new row to the keyboard
         *
         * @param buttons The buttons for the new row
         * @return The keyboard builder
         */
        public InlineKeyboardMarkupBuilder addRow(List<InlineKeyboardButton> buttons) {

            keyboard.add(new LinkedList<>(buttons));
            return this;
        }

        /**
         * Sets a row of the keyboard
         *
         * @param buttons The buttons for the row
         * @return The keyboard builder
         * @throws IndexOutOfBoundsException if the row is out of range
         */
        public InlineKeyboardMarkupBuilder setRow(int row, InlineKeyboardButton... buttons) {

            return setRow(row, Arrays.asList(buttons));
        }

        /**
         * Sets a row of the keyboard
         *
         * @param row        The index of the row
         * @param buttons    The buttons for the row
         * @return The keyboard builder
         * @throws IndexOutOfBoundsException if the row is out of range
         */
        public InlineKeyboardMarkupBuilder setRow(int row, List<InlineKeyboardButton> buttons) {

            keyboard.get(row).clear();
            keyboard.get(row).addAll(buttons);
            return this;
        }

        /**
         * Sets a cell of the keyboard
         *
         * @param row       The index of the row
         * @param column    The index of the column
         * @param button The value for the cell
         * @return The keyboard builder
         * @throws IndexOutOfBoundsException if the row or column is out of range
         */
        public InlineKeyboardMarkupBuilder setCell(int row, int column, InlineKeyboardButton button) {

            keyboard.get(row).set(column, button);
            return this;
        }

        /**
         * Builds the InlineKeyboardMarkup object from the specified options.
         *
         * @return A new InlineKeyboardMarkup.
         */
        public InlineKeyboardMarkup build() {

            return new InlineKeyboardMarkup(this);
        }
    }
}
