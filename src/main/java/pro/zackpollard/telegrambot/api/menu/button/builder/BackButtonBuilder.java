package pro.zackpollard.telegrambot.api.menu.button.builder;

import pro.zackpollard.telegrambot.api.menu.AbstractInlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.InlineMenuRowBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractButtonBuilder;
import pro.zackpollard.telegrambot.api.menu.button.impl.BackButton;
import pro.zackpollard.telegrambot.api.utils.Utils;

/**
 * Builder for BackButton
 * @param <T> menu builder type
 * @see BackButton
 * @author Mazen Kotb
 */
public class BackButtonBuilder<T extends AbstractInlineMenuBuilder>
        extends AbstractButtonBuilder<BackButtonBuilder<T>, T> {
    public BackButtonBuilder(InlineMenuRowBuilder<T> parent, int index) {
        super(parent, index);
    }

    public BackButtonBuilder(InlineMenuRowBuilder<T> parent, int index, String text) {
        super(parent, index, text);
    }

    @Override
    protected BackButtonBuilder<T> instance() {
        return this;
    }

    @Override
    public InlineMenuRowBuilder<T> build() {
        Utils.validateNotNull(text);
        parent.internalAddButton(processButton(new BackButton(null, parent.rowIndex(), index, text)));
        return parent;
    }
}
