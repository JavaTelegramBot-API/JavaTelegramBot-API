package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.menu.button.AbstractInlineMenuButton;

import java.util.regex.Pattern;

/**
 * Registry to hold, and process inline menus and queries.
 *
 * @author Mazen Kotb
 */
public interface InlineMenuRegistry {
    /**
     * Pattern of the callback data put in buttons
     * @see AbstractInlineMenuButton#keyboardBuilder()
     */
    Pattern DATA_PATTERN = Pattern.compile("^im\\.(\\d+)\\.(\\d+)\\.(\\d+)$");

    /**
     * Register the inline menu.
     * Sets internal id
     *
     * @param menu menu to register
     * @see InlineMenu#setInternalId(int)
     */
    void register(InlineMenu menu);

    /**
     * Unregister the inline menu, stopped being listened for
     * @param menu Menu to be unregistered
     */
    void unregister(InlineMenu menu);

    /**
     * Process an inline query
     * @param query Query to process
     * @return Whether to stop event execution or not
     */
    boolean process(CallbackQuery query);
}
