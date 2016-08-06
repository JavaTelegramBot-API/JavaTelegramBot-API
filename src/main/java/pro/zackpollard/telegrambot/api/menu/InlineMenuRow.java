package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class InlineMenuRow {
    List<InlineMenuButton> buttons = new LinkedList<>();

    InlineMenuRow() {
    }

    public InlineMenuButton buttonAt(int index) {
        return buttons.get(index);
    }

    public InlineMenuButton removeButton(int index) {
        return buttons.remove(index);
    }

    public List<InlineKeyboardButton> toButtons() {
        return buttons.stream()
                .map(InlineMenuButton::toKeyboardButton)
                .collect(Collectors.toList());
    }

    public boolean handle(CallbackQuery query, int button) {
        if (button > buttons.size()) {
            return false;
        }

        buttonAt(button).handlePress(query);
        System.out.print("pressed");
        return true;
    }

    public int size() {
        return buttons.size();
    }
}
