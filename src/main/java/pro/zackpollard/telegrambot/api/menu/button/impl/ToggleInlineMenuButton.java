package pro.zackpollard.telegrambot.api.menu.button.impl;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.button.AbstractInlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.callback.ToggleCallback;

public class ToggleInlineMenuButton extends AbstractInlineMenuButton {
    private boolean value;
    private final ToggleCallback callback;

    public ToggleInlineMenuButton(InlineMenu owner, int row, int num, ToggleCallback callback) {
        super(owner, row, num);
        this.callback = callback;
    }

    public ToggleInlineMenuButton(InlineMenu owner, int row, int num, ToggleCallback callback, boolean value) {
        super(owner, row, num);
        this.callback = callback;
        this.value = value;
    }

    public ToggleInlineMenuButton(InlineMenu owner, int row, int num, String text, ToggleCallback callback) {
        super(owner, row, num, text);
        this.callback = callback;
    }

    public ToggleInlineMenuButton(InlineMenu owner, int row, int num, String text, ToggleCallback callback, boolean value) {
        super(owner, row, num, text);
        this.callback = callback;
        this.value = value;

        if (text == null)
            super.text = callback.handleToggle(this, value);
    }

    @Override
    public InlineKeyboardButton toKeyboardButton() {
        return keyboardBuilder().build();
    }

    @Override
    public void handlePress(CallbackQuery query) {
        value = !value;
        setText(callback.handleToggle(this, value));
    }
}
