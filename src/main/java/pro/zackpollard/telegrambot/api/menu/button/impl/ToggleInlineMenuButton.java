package pro.zackpollard.telegrambot.api.menu.button.impl;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.InlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractInlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.builder.ToggleInlineMenuButtonBuilder;
import pro.zackpollard.telegrambot.api.menu.button.callback.ToggleCallback;

/**
 * A button which represents an underlying boolean value.
 * Toggled back and forth with each press.
 *
 * @see ToggleCallback#handleToggle(InlineMenuButton, boolean)
 * @author Mazen Kotb
 */
public class ToggleInlineMenuButton extends AbstractInlineMenuButton {
    private boolean value;
    private final ToggleCallback callback;

    public ToggleInlineMenuButton(InlineMenu owner, int row, ToggleCallback callback) {
        super(owner, row);
        this.callback = callback;
    }

    public ToggleInlineMenuButton(InlineMenu owner, int row, ToggleCallback callback, boolean value) {
        super(owner, row);
        this.callback = callback;
        this.value = value;
    }

    public ToggleInlineMenuButton(InlineMenu owner, int row, String text, ToggleCallback callback) {
        super(owner, row, text);
        this.callback = callback;
    }

    public ToggleInlineMenuButton(InlineMenu owner, int row, String text, ToggleCallback callback, boolean value) {
        super(owner, row, text);
        this.callback = callback;
        this.value = value;

        if (text == null)
            super.text = callback.handleToggle(this, value);
    }


    @Deprecated
    public ToggleInlineMenuButton(InlineMenu owner, int row, int num, ToggleCallback callback) {
        this(owner, row, callback);
    }

    @Deprecated
    public ToggleInlineMenuButton(InlineMenu owner, int row, int num, ToggleCallback callback, boolean value) {
        this(owner, row, callback, value);
    }

    @Deprecated
    public ToggleInlineMenuButton(InlineMenu owner, int row, int num, String text, ToggleCallback callback) {
        this(owner, row, text, callback);
    }

    @Deprecated
    public ToggleInlineMenuButton(InlineMenu owner, int row, int num, String text, ToggleCallback callback, boolean value) {
        this(owner, row, text, callback, value);
    }

    public static ToggleInlineMenuButtonBuilder builder() {
        return new ToggleInlineMenuButtonBuilder<InlineMenuBuilder>(null);
    }

    public static ToggleInlineMenuButtonBuilder builder(String text) {
        return new ToggleInlineMenuButtonBuilder<InlineMenuBuilder>(null, text);
    }

    @Override
    public InlineKeyboardButton toKeyboardButton() {
        return keyboardBuilder().build();
    }

    /**
     * Set the value to the opposite it was before.
     * Set the text of the button to the response of handleToggle()
     *
     * @param query unused
     * @see ToggleCallback#handleToggle(InlineMenuButton, boolean)
     */
    @Override
    public void handlePress(CallbackQuery query) {
        value = !value;
        setText(callback.handleToggle(this, value));
    }
}
