package pro.zackpollard.telegrambot.api.menu.button;

import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.MenuPressable;
import pro.zackpollard.telegrambot.api.menu.button.callback.ButtonCallback;

public interface InlineMenuButton extends MenuPressable {
    String getText();
    void setText(String text);
    InlineMenu getMenu();
    ButtonCallback getCallback();
    InlineMenuButton setCallback(ButtonCallback callback);
    void assignMenu(InlineMenu owner);

    default void executeCallback() {
        ButtonCallback callback = getCallback();

        if (callback != null)
            setText(callback.callback(this));
    }

    InlineKeyboardButton toKeyboardButton();
}
