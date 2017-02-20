package pro.zackpollard.telegrambot.api.menu.button.builder;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.menu.AbstractInlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.InlineMenuRowBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractButtonBuilder;
import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.impl.DummyButton;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.util.function.BiConsumer;

/**
 * The builder for a button which once pressed, executes a callback where
 * the developer can do whatever they want.
 *
 * @author Mazen Kotb
 */
public class DummyButtonBuilder<T extends AbstractInlineMenuBuilder>
        extends AbstractButtonBuilder<DummyButtonBuilder<T>, T> {
    private BiConsumer<DummyButton, CallbackQuery> callback;

    public DummyButtonBuilder(InlineMenuRowBuilder<T> parent) {
        super(parent);
    }

    public DummyButtonBuilder(InlineMenuRowBuilder<T> parent, String text) {
        super(parent, text);
    }

    /**
     * Required. A callback to execute once the button is pressed.
     */
    public DummyButtonBuilder<T> callback(BiConsumer<DummyButton, CallbackQuery> cb) {
        this.callback = cb;
        return this;
    }

    @Override
    protected DummyButtonBuilder<T> instance() {
        return this;
    }

    @Override
    public InlineMenuRowBuilder<T> build() {
        Utils.validateNotNull(text, callback);
        parent.internalAddButton(buildButton());
        return parent;
    }

    @Override
    public InlineMenuButton buildButton() {
        return new DummyButton(null, parent.rowIndex(), text, callback);
    }
}
