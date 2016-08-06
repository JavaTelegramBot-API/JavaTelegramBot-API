package pro.zackpollard.telegrambot.api.menu.button.callback;

import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;

public interface ToggleCallback {
    String handleToggle(InlineMenuButton button, boolean newValue);
}
