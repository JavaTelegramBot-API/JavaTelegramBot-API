package pro.zackpollard.telegrambot.api.menu.button;

import pro.zackpollard.telegrambot.api.menu.AbstractInlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.InlineMenuRowBuilder;
import pro.zackpollard.telegrambot.api.menu.button.callback.ButtonCallback;

/**
 * Abstract methods used across all button creation
 * @param <T> implementing type
 * @param <E> menu builder type
 * @author Mazen Kotb
 */
public abstract class AbstractButtonBuilder<T, E extends AbstractInlineMenuBuilder> {
    protected final InlineMenuRowBuilder<E> parent;
    protected final int index;
    protected String text;
    protected ButtonCallback callback;

    protected AbstractButtonBuilder(InlineMenuRowBuilder<E> parent, int index) {
        this.parent = parent;
        this.index = index;
    }

    protected AbstractButtonBuilder(InlineMenuRowBuilder<E> parent, int index, String text) {
        this.parent = parent;
        this.index = index;
        this.text = text;
    }

    protected abstract T instance();

    /**
     * Build the current builder
     * @return parent row builder
     */
    public abstract InlineMenuRowBuilder<E> build();

    /**
     * Set the text of the current button. Required call unless provided at init
     * @param text Text to be set
     * @return this
     */
    public T text(String text) {
        this.text = text;
        return instance();
    }

    /**
     * Set the button callback of this builder.
     * @param callback Callback to be set
     * @return this
     */
    public T buttonCallback(ButtonCallback callback) {
        this.callback = callback;
        return instance();
    }

    /**
     * Build the current button, delegate to parent's newRow method
     * @return new row builder
     * @see InlineMenuRowBuilder#newRow()
     */
    public InlineMenuRowBuilder<E> newRow() {
        build();
        return parent.newRow();
    }

    /**
     * Build the current button, delegate to parent's build method
     * @return current menu builder
     * @see InlineMenuRowBuilder#build()
     */
    public E buildRow() {
        build();
        return parent.build();
    }

    /**
     * Build the button, build the parent's row, build the menu
     * @return built menu
     * @see InlineMenuRowBuilder#build()
     * @see AbstractInlineMenuBuilder#buildMenu()
     */
    public InlineMenu buildMenu() {
        build();
        return parent.build().buildMenu();
    }

    protected InlineMenuButton processButton(InlineMenuButton button) {
        return button.setCallback(callback);
    }
}
