package pro.zackpollard.telegrambot.api.menu.button.callback;

import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;

/**
 * Acts as a Function, executes and updates button text
 * @author Mazen Kotb
 */
public interface ButtonCallback {
    /**
     * Executed whenever the button is pressed.
     * Text will not change if null is returned
     * @param button Button being pressed
     * @return updated text, null will be ignored
     */
    String callback(InlineMenuButton button);
}
