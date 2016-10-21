package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Wrapper class to represent a list of button in a row.
 *
 * @author Mazen Kotb
 */
public class InlineMenuRow {
    List<InlineMenuButton> buttons = new LinkedList<>();

    InlineMenuRow() {
    }

    /**
     * Get button at index
     * @param index index
     * @return Found button
     * @throws IndexOutOfBoundsException if provided index is out of bounds
     */
    public InlineMenuButton buttonAt(int index) {
        return buttons.get(index);
    }

    /**
     * Removes button at index
     * @param index Index of the button to remove
     * @return Button which was removed
     */
    public InlineMenuButton removeButton(int index) {
        return buttons.remove(index);
    }

    /**
     * Returns row as List&lt;InlineKeyboardButtons&gt;
     * @return list of keyboard buttons
     * @see InlineMenuButton#toKeyboardButton()
     */
    public List<InlineKeyboardButton> toButtons() {
        return buttons.stream()
                .map(InlineMenuButton::toKeyboardButton)
                .collect(Collectors.toList());
    }

    /**
     * Handle callback query
     * @param query query to be processed
     * @param button button index
     * @return false if the button was out of bounds and therefore wasn't processed
     */
    public boolean handle(CallbackQuery query, int button) {
        if (button < 0 || button > buttons.size()) {
            return false;
        }

        buttonAt(button).handlePress(query);
        return true;
    }

    /**
     * Size of the row
     * @return size of row
     */
    public int size() {
        return buttons.size();
    }
}
