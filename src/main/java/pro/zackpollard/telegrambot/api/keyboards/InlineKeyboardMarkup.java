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
public class InlineKeyboardMarkup implements InlineKeyboard {

    private final List<List<InlineKeyboardButton>> inline_keyboard;

    private InlineKeyboardMarkup(InlineKeyboardMarkupBuilder builder) {

        this.inline_keyboard = builder.inline_keyboard;
    }

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineKeyboardMarkupBuilder object used to construct the InlineKeyboardMarkup object
     */
    public static InlineKeyboardMarkupBuilder builder() {

        return new InlineKeyboardMarkupBuilder();
    }

    /**
     * Gets Array of button rows, each represented by an Array of Strings
     *
     * @return Button rows
     */
    public List<List<InlineKeyboardButton>> getButtons() {

        return inline_keyboard;
    }

    /**
     * Gets the ReplyMarkupType for this ReplyMarkup object
     *
     * @return The ReplyMarkupType for this ReplyMarkup object
     */
    @Override
    public ReplyMarkupType getType() {
        return ReplyMarkupType.INLINE_KEYBOARD_MARKUP;
    }

    @ToString
    public static class InlineKeyboardMarkupBuilder {

        private final List<List<InlineKeyboardButton>> inline_keyboard = new LinkedList<>();

        private InlineKeyboardMarkupBuilder() {
        }

        /**
         * *Optional*
         * Add a new row to the keyboard
         *
         * @param buttons The buttons for the new row
         *
         * @return The keyboard builder
         */
        public InlineKeyboardMarkupBuilder addRow(InlineKeyboardButton... buttons) {

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
        public InlineKeyboardMarkupBuilder addRow(List<InlineKeyboardButton> buttons) {

            inline_keyboard.add(new LinkedList<>(buttons));
            return this;
        }

        /**
         * *Optional*
         * Sets a row of the keyboard
         *
         * @param buttons The buttons for the row
         *
         * @return The keyboard builder
         *
         * @throws IndexOutOfBoundsException if the row is out of range
         */
        public InlineKeyboardMarkupBuilder setRow(int row, InlineKeyboardButton... buttons) {

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
        public InlineKeyboardMarkupBuilder setRow(int row, List<InlineKeyboardButton> buttons) {

            inline_keyboard.get(row).clear();
            inline_keyboard.get(row).addAll(buttons);
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
        public InlineKeyboardMarkupBuilder setCell(int row, int column, InlineKeyboardButton button) {

            inline_keyboard.get(row).set(column, button);
            return this;
        }

        /**
         * Builds the InlineKeyboardMarkup object
         *
         * @return A InlineKeyboardMarkup object based on the previously provided values
         */
        public InlineKeyboardMarkup build() {

            return new InlineKeyboardMarkup(this);
        }
    }
}
