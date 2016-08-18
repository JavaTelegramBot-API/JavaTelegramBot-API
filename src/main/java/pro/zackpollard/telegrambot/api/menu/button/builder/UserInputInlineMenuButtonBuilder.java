package pro.zackpollard.telegrambot.api.menu.button.builder;

import pro.zackpollard.telegrambot.api.menu.AbstractInlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.InlineMenuRowBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractButtonBuilder;
import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.callback.ButtonCallback;
import pro.zackpollard.telegrambot.api.menu.button.impl.UserInputInlineMenuButton;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.util.function.BiConsumer;

/**
 * Builder for user input buttons.
 *
 * Methods text(), buttonCallback() and textCallback() must all be called
 *
 * @param <T> menu builder type
 * @see UserInputInlineMenuButton
 * @see AbstractButtonBuilder#text(String)
 * @see AbstractButtonBuilder#buttonCallback(ButtonCallback)
 * @see UserInputInlineMenuButtonBuilder#textCallback(BiConsumer)
 * @author Mazen Kotb
 */
public class UserInputInlineMenuButtonBuilder<T extends AbstractInlineMenuBuilder>
        extends AbstractButtonBuilder<UserInputInlineMenuButtonBuilder<T>, T> {
    private BiConsumer<InlineMenuButton, String> textCallback;

    public UserInputInlineMenuButtonBuilder(InlineMenuRowBuilder<T> parent, int index) {
        super(parent, index);
    }

    public UserInputInlineMenuButtonBuilder(InlineMenuRowBuilder<T> parent, int index, String text) {
        super(parent, index, text);
    }

    @Override
    protected UserInputInlineMenuButtonBuilder<T> instance() {
        return this;
    }

    /**
     * Required. callback to be executed on input
     * @param textCallback callback to be executed on input
     * @return this
     */
    public UserInputInlineMenuButtonBuilder<T> textCallback(BiConsumer<InlineMenuButton, String> textCallback) {
        this.textCallback = textCallback;
        return this;
    }

    @Override
    public InlineMenuRowBuilder<T> build() {
        Utils.validateNotNull(text, callback, textCallback);
        parent.internalAddButton(processButton(new UserInputInlineMenuButton(null, parent.rowIndex(), index, text, textCallback)));
        return parent;
    }
}
