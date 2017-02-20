package pro.zackpollard.telegrambot.api.menu.button.impl;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.InlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractInlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.builder.BackButtonBuilder;

/**
 * A button which once pressed will exit it's current menu
 * and as a result open the last seen menu.
 *
 * NOTE: Given a menu scenario like this:
 *
 * Menu 1 <-> Menu 2 <-> Menu 3
 *
 * If the user goes from 1->2->3 then hits the back button
 * on 3, it will take them back to 2. If they hit the back
 * button on 2, it will return them to menu 1. This is to
 * best follow their menu history and not send them to menu
 * 3 when they hit the back button on menu 2 after they've
 * been to menu 3. (what a sentence)
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
     * If there is a last menu, execute callback, unregister the current menu, and start the parent.
     *
     * @param query Query to process, unused.
     * @see InlineMenu#unregister()
     * @see InlineMenu#start()
     */
    @Override
    public void handlePress(CallbackQuery query) {
        InlineMenu lastMenu = owner.getLastMenu();

        if (lastMenu != null) {
            executeCallback();
            owner.unregister();
            lastMenu.start();
        }
    }
}
