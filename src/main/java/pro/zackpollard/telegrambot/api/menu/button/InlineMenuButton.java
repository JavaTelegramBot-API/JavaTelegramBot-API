package pro.zackpollard.telegrambot.api.menu.button;

import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.MenuPressable;
import pro.zackpollard.telegrambot.api.menu.button.callback.ButtonCallback;

/**
 * Represents a button in an inline menu
 *
 * @author Mazen Kotb
 */
public interface InlineMenuButton extends MenuPressable {
    /**
     * @return Text of the button
     */
    String getText();

    /**
     * Set the text of the button
     * @param text Text to set it to
     */
    void setText(String text);

    /**
     * @return the menu owning this button
     */
    InlineMenu getMenu();

    /**
     * @return current callback of the button
     */
    ButtonCallback getCallback();

    /**
     * Set the callback of this button
     * @param callback Callback to set
     * @return current instance
     */
    InlineMenuButton setCallback(ButtonCallback callback);

    /**
     * Assign this button to it's menu owner. May only be called once
     * @param owner New menu owner
     */
    void assignMenu(InlineMenu owner);

    /**
     * Execute the callback. Sets the text to the response of the callback
     *
     * @see ButtonCallback#callback(InlineMenuButton)
     */
    default void executeCallback() {
        ButtonCallback callback = getCallback();

        if (callback != null)
            setText(callback.callback(this));
    }

    /**
     * @return this as an inline keyboard button
     */
    InlineKeyboardButton toKeyboardButton();

    void updateRow(int row);
}
