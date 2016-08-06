package pro.zackpollard.telegrambot.api.menu.button.builder;

import pro.zackpollard.telegrambot.api.menu.AbstractInlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.InlineMenuRowBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractButtonBuilder;
import pro.zackpollard.telegrambot.api.menu.button.callback.ToggleCallback;
import pro.zackpollard.telegrambot.api.menu.button.impl.ToggleInlineMenuButton;
import pro.zackpollard.telegrambot.api.utils.Utils;

public class ToggleInlineMenuButtonBuilder<T extends AbstractInlineMenuBuilder> extends
        AbstractButtonBuilder<ToggleInlineMenuButtonBuilder<T>, T> {
    private boolean initialValue = false;
    private ToggleCallback toggleCallback;

    public ToggleInlineMenuButtonBuilder(InlineMenuRowBuilder<T> parent, int index) {
        super(parent, index);
    }

    @Override
    protected ToggleInlineMenuButtonBuilder<T> instance() {
        return this;
    }

    public ToggleInlineMenuButtonBuilder<T> initialValue(boolean value) {
        this.initialValue = value;
        return this;
    }

    public ToggleInlineMenuButtonBuilder<T> toggleCallback(ToggleCallback callback) {
        this.toggleCallback = callback;
        return this;
    }

    @Override
    public InlineMenuRowBuilder<T> build() {
        Utils.validateNotNull(toggleCallback);
        parent.internalAddButton(processButton(new ToggleInlineMenuButton(null, parent.rowIndex(), index, text, toggleCallback, initialValue)));
        return parent;
    }
}
