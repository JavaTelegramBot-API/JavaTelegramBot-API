package pro.zackpollard.telegrambot.api.menu.button;


import lombok.Getter;
import lombok.Setter;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.button.callback.ButtonCallback;

/**
 * Abstract implementation of InlineMenuButton
 *
 * @author Mazen Kotb
 */
public abstract class AbstractInlineMenuButton implements InlineMenuButton {
    protected ButtonCallback buttonCallback;
    protected String text;
    @Getter
    protected int row;
    @Getter
    @Setter
    protected InlineMenu owner;

    protected AbstractInlineMenuButton(InlineMenu owner, int row) {
        this.owner = owner;
        this.row = row;
    }

    @Deprecated
    protected AbstractInlineMenuButton(InlineMenu owner, int row, int num) {
        this(owner, row);
    }


    protected AbstractInlineMenuButton(InlineMenu owner, int row, String text) {
        this(owner, row);
        this.text = text;
    }

    @Deprecated
    protected AbstractInlineMenuButton(InlineMenu owner, int row, int num, String text) {
        this(owner, row, text);
    }

    @Override
    public InlineMenu getMenu() {
        return owner;
    }

    @Override
    public void setText(String text) {
        if (text != null) {
            this.text = text;
            owner.apply();
        }
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public ButtonCallback getCallback() {
        return buttonCallback;
    }

    @Override
    public InlineMenuButton setCallback(ButtonCallback callback) {
        this.buttonCallback = callback;
        return this;
    }

    @Override
    public void assignMenu(InlineMenu owner) {
        this.owner = owner;
    }

    @Deprecated
    public int getNum() {
        return owner.rowAt(row).indexOf(this);
    }

    @Override
    public void updateRow(int row) {
        this.row = row;
    }

    /**
     * Sets the text of the button and the callback data to the following.
     *
     * im.x.y.z
     *
     * Where x is the internal id of the owning menu,
     *       y is the row index,
     *       z is the button index.
     *
     * @return Premade button builder
     */
    protected InlineKeyboardButton.InlineKeyboardButtonBuilder keyboardBuilder() {
        return InlineKeyboardButton.builder()
                .text(text)
                .callbackData("im." + owner.getInternalId() + "." + row + "." + owner.rowAt(row).indexOf(this));
    }
}
