package pro.zackpollard.telegrambot.api.menu.button.impl;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.button.AbstractInlineMenuButton;

import java.util.function.BiConsumer;

/**
 * A button which once pressed, executes a callback where
 * the developer can do whatever they want.
 *
 * @author Mazen Kotb
 */
public class DummyButton extends AbstractInlineMenuButton {
    private BiConsumer<DummyButton, CallbackQuery> callback;

    public DummyButton(InlineMenu owner, int row, BiConsumer<DummyButton, CallbackQuery> callback) {
        super(owner, row);
        this.callback = callback;
    }

    public DummyButton(InlineMenu owner, int row, String text, BiConsumer<DummyButton, CallbackQuery> callback) {
        super(owner, row, text);
        this.callback = callback;
    }

    @Override
    public InlineKeyboardButton toKeyboardButton() {
        return keyboardBuilder().build();
    }

    @Override
    public void handlePress(CallbackQuery query) {
        executeCallback();
        callback.accept(this, query);
    }
}
