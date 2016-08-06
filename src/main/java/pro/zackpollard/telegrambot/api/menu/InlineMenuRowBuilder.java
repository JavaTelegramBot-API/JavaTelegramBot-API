package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.builder.BackButtonBuilder;
import pro.zackpollard.telegrambot.api.menu.button.builder.SubInlineMenuButtonBuilder;
import pro.zackpollard.telegrambot.api.menu.button.builder.ToggleInlineMenuButtonBuilder;
import pro.zackpollard.telegrambot.api.menu.button.builder.UserInputInlineMenuButtonBuilder;

import java.util.List;

public class InlineMenuRowBuilder<T extends AbstractInlineMenuBuilder> {
    private final T parent;
    private final InlineMenuRow row = new InlineMenuRow();
    private final int index;

    InlineMenuRowBuilder(T parent, int index) {
        this.parent = parent;
        this.index = index;
    }

    public void internalAddButton(InlineMenuButton button) {
        row.buttons.add(button);
    }

    public ToggleInlineMenuButtonBuilder<T> toggleButton() {
        return new ToggleInlineMenuButtonBuilder<>(this, buttons().size());
    }

    public UserInputInlineMenuButtonBuilder<T> inputButton() {
        return new UserInputInlineMenuButtonBuilder<>(this, buttons().size());
    }

    public SubInlineMenuButtonBuilder<T> menuButton() {
        return new SubInlineMenuButtonBuilder<>(this, buttons().size());
    }

    public BackButtonBuilder<T> backButton() {
        return new BackButtonBuilder<>(this, buttons().size());
    }

    public InlineMenuRowBuilder removeLast() {
        List<InlineMenuButton> buttons = buttons();

        if (buttons.size() != 0)
            buttons.remove(buttons.size() - 1);

        return this;
    }

    public int rowIndex() {
        return index;
    }

    private List<InlineMenuButton> buttons() {
        return row.buttons;
    }

    public T build() {
        parent.rows.add(row);
        return parent;
    }
}
