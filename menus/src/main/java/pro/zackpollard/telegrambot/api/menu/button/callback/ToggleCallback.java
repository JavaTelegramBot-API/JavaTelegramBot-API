package pro.zackpollard.telegrambot.api.menu.button.callback;

import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;

/**
 * Called to update text whenever a ToggleInlineMenuButton is pressed.
 * Provides updated value
 *
 * @author Mazen Kotb
 * @see pro.zackpollard.telegrambot.api.menu.button.impl.ToggleInlineMenuButton
 */
public interface ToggleCallback {
    /**
     * @param button Owning button
     * @param newValue new value based on the press
     * @return new button text, null will be ignored
     */
    String handleToggle(InlineMenuButton button, boolean newValue);
}
