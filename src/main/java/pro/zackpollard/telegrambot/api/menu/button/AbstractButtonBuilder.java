package pro.zackpollard.telegrambot.api.menu.button;

import pro.zackpollard.telegrambot.api.menu.AbstractInlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.InlineMenuRowBuilder;
import pro.zackpollard.telegrambot.api.menu.button.callback.ButtonCallback;

public abstract class AbstractButtonBuilder<T, E extends AbstractInlineMenuBuilder> {
    protected final InlineMenuRowBuilder<E> parent;
    protected final int index;
    protected String text;
    protected ButtonCallback callback;

    protected AbstractButtonBuilder(InlineMenuRowBuilder<E> parent, int index) {
        this.parent = parent;
        this.index = index;
    }

    protected abstract T instance();

    public abstract InlineMenuRowBuilder build();

    public T text(String text) {
        this.text = text;
        return instance();
    }

    public T buttonCallback(ButtonCallback callback) {
        this.callback = callback;
        return instance();
    }

    protected InlineMenuButton processButton(InlineMenuButton button) {
        return button.setCallback(callback);
    }
}
