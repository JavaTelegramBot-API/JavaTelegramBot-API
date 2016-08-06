package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;

public interface MenuPressable {
    void handlePress(CallbackQuery query);
}
