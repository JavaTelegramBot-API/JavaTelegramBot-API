package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;

/**
 * An item which can be pressed, handling a callback query
 *
 * @author Mazen Kotb
 * @see InlineMenuRow#handle(CallbackQuery, int)
 */
public interface MenuPressable {
    void handlePress(CallbackQuery query);
}
