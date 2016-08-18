package pro.zackpollard.telegrambot.api.menu.button.impl;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.button.AbstractInlineMenuButton;

/**
 * A button which opens a sub menu.
 *
 * @author Mazen Kotb
 */
public class SubInlineMenuButton extends AbstractInlineMenuButton {
    private final InlineMenu nextMenu;

    public SubInlineMenuButton(InlineMenu owner, int row, int num, InlineMenu nextMenu) {
        super(owner, row, num);
        this.nextMenu = nextMenu;
    }

    public SubInlineMenuButton(InlineMenu owner, int row, int num, InlineMenu nextMenu, String text) {
        super(owner, row, num, text);
        this.nextMenu = nextMenu;
    }

    @Override
    public InlineKeyboardButton toKeyboardButton() {
        return keyboardBuilder().build();
    }

    @Override
    public void handlePress(CallbackQuery query) {
        executeCallback();
        owner.unregister();
        nextMenu.start();
    }
}
