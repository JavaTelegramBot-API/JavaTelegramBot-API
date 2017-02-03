package pro.zackpollard.telegrambot.api.menu.button.impl;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.InlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractInlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.builder.BackButtonBuilder;

/**
 * A button which once pressed will exit it's current menu
 * and as a result open it's parent's.
 *
 * @author Mazen Kotb
 */
public class BackButton extends AbstractInlineMenuButton {
    @Deprecated
    public BackButton(InlineMenu owner, int row, int num) {
        super(owner, row, num);
    }

    @Deprecated
    public BackButton(InlineMenu owner, int row, int num, String text) {
        super(owner, row, num, text);
    }

    public BackButton(InlineMenu owner, int row) {
        super(owner, row);
    }

    public BackButton(InlineMenu owner, int row, String text) {
        super(owner, row, text);
    }

    public static BackButtonBuilder builder() {
        return new BackButtonBuilder<InlineMenuBuilder>(null);
    }

    public static BackButtonBuilder builder(String text) {
        return new BackButtonBuilder<InlineMenuBuilder>(null, text);
    }

    @Override
    public InlineKeyboardButton toKeyboardButton() {
        return keyboardBuilder().build();
    }

    /**
     * If there is a valid parent, execute callback, unregister the current menu, and start the parent.
     *
     * @param query Query to process, unused.
     * @see InlineMenu#unregister()
     * @see InlineMenu#start()
     */
    @Override
    public void handlePress(CallbackQuery query) {
        InlineMenu parent = owner.getParent();

        if (parent != null) {
            executeCallback();
            owner.unregister();
            parent.start();
        }
    }
}
