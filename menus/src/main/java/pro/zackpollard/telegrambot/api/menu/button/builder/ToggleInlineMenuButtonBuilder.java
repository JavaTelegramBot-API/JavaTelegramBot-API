package pro.zackpollard.telegrambot.api.menu.button.builder;

import pro.zackpollard.telegrambot.api.menu.AbstractInlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.InlineMenuRowBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractButtonBuilder;
import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.callback.ToggleCallback;
import pro.zackpollard.telegrambot.api.menu.button.impl.ToggleInlineMenuButton;
import pro.zackpollard.telegrambot.api.utils.Utils;

/**
 * Builder for Toggle buttons
 * @param <T> menu builder type
 * @author Mazen Kotb
 */
public class ToggleInlineMenuButtonBuilder<T extends AbstractInlineMenuBuilder> extends
        AbstractButtonBuilder<ToggleInlineMenuButtonBuilder<T>, T> {
    private boolean initialValue = false;
    private ToggleCallback toggleCallback;

    public ToggleInlineMenuButtonBuilder(InlineMenuRowBuilder<T> parent) {
        super(parent);
    }

    public ToggleInlineMenuButtonBuilder(InlineMenuRowBuilder<T> parent, String text) {
        super(parent, text);
    }

    @Deprecated
    public ToggleInlineMenuButtonBuilder(InlineMenuRowBuilder<T> parent, int index) {
        super(parent, index);
    }

    @Deprecated
    public ToggleInlineMenuButtonBuilder(InlineMenuRowBuilder<T> parent, int index, String text) {
        super(parent, index, text);
    }

    @Override
    protected ToggleInlineMenuButtonBuilder<T> instance() {
        return this;
    }

    /**
     * Initial value of the button
     * @param value initial value
     * @return this
     */
    public ToggleInlineMenuButtonBuilder<T> initialValue(boolean value) {
        this.initialValue = value;
        return this;
    }

    /**
     * Required.
     * @param callback Callback to be executed when button is pressed
     * @return this
     */
    public ToggleInlineMenuButtonBuilder<T> toggleCallback(ToggleCallback callback) {
        this.toggleCallback = callback;
        return this;
    }

    @Override
    public InlineMenuRowBuilder<T> build() {
        Utils.validateNotNull(toggleCallback);
        parent.internalAddButton(buildButton());
        return parent;
    }

    @Override
    public ToggleInlineMenuButton buildButton() {
        return processButton(new ToggleInlineMenuButton(null, parent.rowIndex(), text, toggleCallback, initialValue));
    }
}
