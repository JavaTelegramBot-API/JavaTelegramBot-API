package pro.zackpollard.telegrambot.api.menu.button.impl;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.InlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractInlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.builder.SubInlineMenuButtonBuilder;

import java.util.function.Supplier;

/**
 * A button which opens a sub menu.
 *
 * @author Mazen Kotb
 */
public class SubInlineMenuButton extends AbstractInlineMenuButton {
    private final Supplier<InlineMenu> nextMenu;

    @Deprecated
    public SubInlineMenuButton(InlineMenu owner, int row, InlineMenu nextMenu) {
        super(owner, row);
        this.nextMenu = () -> nextMenu;
    }

    @Deprecated
    public SubInlineMenuButton(InlineMenu owner, int row, InlineMenu nextMenu, String text) {
        super(owner, row, text);
        this.nextMenu = () -> nextMenu;
    }

    public SubInlineMenuButton(InlineMenu owner, int row, Supplier<InlineMenu> nextMenu) {
        super(owner, row);
        this.nextMenu = nextMenu;
    }

    public SubInlineMenuButton(InlineMenu owner, int row, Supplier<InlineMenu> nextMenu, String text) {
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
        InlineMenu menu = nextMenu.get();

        menu.setLastMenu(owner);
        menu.start();
    }
}
