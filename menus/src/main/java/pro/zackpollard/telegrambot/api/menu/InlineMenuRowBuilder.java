package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.builder.*;

import java.util.List;

/**
 * Builder for rows
 *
 * @param <T> Type of the parent menu builder
 */
public class InlineMenuRowBuilder<T extends AbstractInlineMenuBuilder> {
    private final T parent;
    private final InlineMenuRow row = new InlineMenuRow();
    private final int index;

    InlineMenuRowBuilder(T parent, int index) {
        this.parent = parent;
        this.index = index;
    }

    /**
     * Called by button builders to add the button to the row.
     * Not caller dependent.
     *
     * @param button Button to add
     */
    public void internalAddButton(InlineMenuButton button) {
        row.buttons.add(button);
    }

    /**
     * Creates a new toggle button builder.
     * @return a new toggle button builder
     * @see pro.zackpollard.telegrambot.api.menu.button.impl.ToggleInlineMenuButton
     */
    public ToggleInlineMenuButtonBuilder<T> toggleButton() {
        return new ToggleInlineMenuButtonBuilder<>(this);
    }

    /**
     * Creates a new toggle button builder with provided text
     * @param text Text for the button to initialize with
     * @return new toggle button builder
     * @see pro.zackpollard.telegrambot.api.menu.button.impl.ToggleInlineMenuButton
     */
    public ToggleInlineMenuButtonBuilder<T> toggleButton(String text) {
        return new ToggleInlineMenuButtonBuilder<>(this, text);
    }

    /**
     * Creates a new user input button builder
     * @return a new user input button builder
     * @see pro.zackpollard.telegrambot.api.menu.button.impl.UserInputInlineMenuButton
     */
    public UserInputInlineMenuButtonBuilder<T> inputButton() {
        return new UserInputInlineMenuButtonBuilder<>(this);
    }

    /**
     * Creates new user input button builder with provided text
     * @param text Text for the button to initialize with
     * @return new user input button builder
     * @see pro.zackpollard.telegrambot.api.menu.button.impl.UserInputInlineMenuButton
     */
    public UserInputInlineMenuButtonBuilder<T> inputButton(String text) {
        return new UserInputInlineMenuButtonBuilder<>(this, text);
    }

    /**
     * Creates a new submenu button builder
     * @return a new submenu button builder
     * @see pro.zackpollard.telegrambot.api.menu.button.impl.SubInlineMenuButton
     */
    public SubInlineMenuButtonBuilder<T> menuButton() {
        return new SubInlineMenuButtonBuilder<>(this);
    }

    /**
     * Creates a new submenu button builder with provided text
     * @param text Text for the button to initialize with
     * @return a new submenu button builder
     * @see pro.zackpollard.telegrambot.api.menu.button.impl.SubInlineMenuButton
     */
    public SubInlineMenuButtonBuilder<T> menuButton(String text) {
        return new SubInlineMenuButtonBuilder<>(this, text);
    }

    /**
     * Creates a new back button builder.
     * @return a new back button builder
     * @see pro.zackpollard.telegrambot.api.menu.button.impl.BackButton
     */
    public BackButtonBuilder<T> backButton() {
        if (!(parent instanceof SubInlineMenuBuilder)) {
            throw new UnsupportedOperationException("Back buttons are only allowed for sub menus!");
        }

        return new BackButtonBuilder<>(this);
    }

    /**
     * Creates a new back button builder with provided text
     * @param text Text for the button to initialize with
     * @return a new back button builder
     * @see pro.zackpollard.telegrambot.api.menu.button.impl.BackButton
     */
    public BackButtonBuilder<T> backButton(String text) {
        return new BackButtonBuilder<>(this, text);
    }

    /**
     * Creates a new dummy button builder with provided text
     * @param text Text for the button to initialize with
     * @return a new dummy button builder
     * @see pro.zackpollard.telegrambot.api.menu.button.impl.DummyButton
     */
    public DummyButtonBuilder<T> dummyButton(String text) {
        return new DummyButtonBuilder<>(this, text);
    }

    /**
     * Creates a new dummy button builder
     * @return a new dummy button builder
     * @see pro.zackpollard.telegrambot.api.menu.button.impl.DummyButton
     */
    public DummyButtonBuilder<T> dummyButton() {
        return new DummyButtonBuilder<>(this);
    }

    /**
     * Remove the last button in the stack
     * @return this
     */
    public InlineMenuRowBuilder removeLast() {
        List<InlineMenuButton> buttons = buttons();

        if (buttons.size() != 0)
            buttons.remove(buttons.size() - 1);

        return this;
    }

    /**
     * @return the index of this row
     */
    public int rowIndex() {
        return index;
    }

    private List<InlineMenuButton> buttons() {
        return row.buttons;
    }

    public InlineMenuRow buildRow() {
        return row;
    }

    /**
     * Build the row. Adds itself to the parent
     * @return The parent builder
     */
    public T build() {
        parent.rows.add(row);
        return parent;
    }

    /**
     * Build the row. add itself to the parent.
     * @return builder from newRow() call on parent builder
     * @see AbstractInlineMenuBuilder#newRow()
     */
    public InlineMenuRowBuilder<T> newRow() {
        build();
        return parent.newRow();
    }
}
