package pro.zackpollard.telegrambot.api.menu.button.impl;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.InlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractInlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.builder.SubInlineMenuButtonBuilder;

/**
 * A button which opens a sub menu.
 *
 * @author Mazen Kotb
 */
public class SubInlineMenuButton extends AbstractInlineMenuButton {
    private final InlineMenu nextMenu;

    @Deprecated
    public SubInlineMenuButton(InlineMenu owner, int row, int num, InlineMenu nextMenu) {
        super(owner, row, num);
        this.nextMenu = nextMenu;
    }

    @Deprecated
    public SubInlineMenuButton(InlineMenu owner, int row, int num, InlineMenu nextMenu, String text) {
        super(owner, row, num, text);
        this.nextMenu = nextMenu;
    }

    public SubInlineMenuButton(InlineMenu owner, int row, InlineMenu nextMenu) {
        super(owner, row);
        this.nextMenu = nextMenu;
    }

    public SubInlineMenuButton(InlineMenu owner, int row, InlineMenu nextMenu, String text) {
        super(owner, row, text);
        this.nextMenu = nextMenu;
    }


    public static SubInlineMenuButtonBuilder builder() {
        return new SubInlineMenuButtonBuilder<InlineMenuBuilder>(null);
    }

    public static SubInlineMenuButtonBuilder builder(String text) {
        return new SubInlineMenuButtonBuilder<InlineMenuBuilder>(null, text);
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
