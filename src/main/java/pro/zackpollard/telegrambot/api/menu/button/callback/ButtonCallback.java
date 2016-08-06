package pro.zackpollard.telegrambot.api.menu.button.callback;

import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;

public interface ButtonCallback {
    // returns new button text
    String callback(InlineMenuButton button);
}
