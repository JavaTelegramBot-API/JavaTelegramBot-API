package pro.zackpollard.telegrambot.api.menu.button.builder;

import pro.zackpollard.telegrambot.api.menu.AbstractInlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.InlineMenuRowBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractButtonBuilder;
import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.impl.UserInputInlineMenuButton;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.util.function.BiConsumer;

public class UserInputInlineMenuButtonBuilder<T extends AbstractInlineMenuBuilder>
        extends AbstractButtonBuilder<UserInputInlineMenuButtonBuilder<T>, T> {
    private BiConsumer<InlineMenuButton, String> textCallback;

    public UserInputInlineMenuButtonBuilder(InlineMenuRowBuilder<T> parent, int index) {
        super(parent, index);
    }

    @Override
    protected UserInputInlineMenuButtonBuilder<T> instance() {
        return this;
    }

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
