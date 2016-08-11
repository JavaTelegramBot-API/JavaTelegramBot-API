package pro.zackpollard.telegrambot.api.menu.button;


import lombok.Getter;
import lombok.Setter;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableTextMessage.SendableTextMessageBuilder;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.button.callback.ButtonCallback;

public abstract class AbstractInlineMenuButton implements InlineMenuButton {
    protected ButtonCallback buttonCallback;
    protected String text;
    @Getter
    protected final int row;
    @Getter
    protected final int num;
    @Getter
    @Setter
    protected InlineMenu owner;

    protected AbstractInlineMenuButton(InlineMenu owner, int row, int num) {
        this.owner = owner;
        this.row = row;
        this.num = num;
    }

    protected AbstractInlineMenuButton(InlineMenu owner, int row, int num, String text) {
        this(owner, row, num);
        this.text = text;
    }

    @Override
    public void setMessageText(SendableTextMessageBuilder text) {
        owner.setMessageText(text);
    }

    @Override
    public void setText(String text) {
        this.text = text;
        owner.apply();
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

    protected InlineKeyboardButton.InlineKeyboardButtonBuilder keyboardBuilder() {
        return InlineKeyboardButton.builder()
                .text(text)
                .callbackData("im." + owner.getInternalId() + "." + row + "." + num);
    }
}
