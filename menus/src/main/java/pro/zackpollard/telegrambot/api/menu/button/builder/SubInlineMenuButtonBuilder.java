package pro.zackpollard.telegrambot.api.menu.button.builder;

import pro.zackpollard.telegrambot.api.menu.AbstractInlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.InlineMenuRowBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractButtonBuilder;
import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.impl.SubInlineMenuButton;
import pro.zackpollard.telegrambot.api.utils.Utils;

/**
 * Builder for SubMenus
 * @param <T> menu builder type
 * @see SubInlineMenuButton
 * @author Mazen Kotb
 */
public class SubInlineMenuButtonBuilder<T extends AbstractInlineMenuBuilder>
        extends AbstractButtonBuilder<SubInlineMenuButtonBuilder<T>, T> {
    private InlineMenu nextMenu;

    public SubInlineMenuButtonBuilder(InlineMenuRowBuilder<T> parent) {
        super(parent);
    }

    public SubInlineMenuButtonBuilder(InlineMenuRowBuilder<T> parent, String text) {
        super(parent, text);
    }

    @Deprecated
    public SubInlineMenuButtonBuilder(InlineMenuRowBuilder<T> parent, int index) {
        super(parent, index);
    }

    @Deprecated
    public SubInlineMenuButtonBuilder(InlineMenuRowBuilder<T> parent, int index, String text) {
        super(parent, index, text);
    }

    @Override
    protected SubInlineMenuButtonBuilder<T> instance() {
        return this;
    }

    /**
     * Required. Set the nextMenu field.
     * @param menu menu which will open when the button is pressed
     * @return this
     */
    public SubInlineMenuButtonBuilder<T> nextMenu(InlineMenu menu) {
        this.nextMenu = menu;
        return this;
    }

    @Override
    public InlineMenuRowBuilder<T> build() {
        Utils.validateNotNull(text, nextMenu);
        parent.internalAddButton(buildButton());
        return parent;
    }

    @Override
    public SubInlineMenuButton buildButton() {
        return processButton(new SubInlineMenuButton(null, parent.rowIndex(), nextMenu, text));
    }
}
