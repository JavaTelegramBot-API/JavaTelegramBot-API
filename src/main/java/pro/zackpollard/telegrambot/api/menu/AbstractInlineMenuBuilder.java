package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.chat.message.Message;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractInlineMenuBuilder<T extends AbstractInlineMenuBuilder> {
    List<InlineMenuRow> rows = new ArrayList<>();

    public InlineMenuRowBuilder<T> row() {
        return new InlineMenuRowBuilder<>(instance(), rows.size());
    }

    protected abstract T instance();

    protected InlineMenu buildMenu(Message base) {
        InlineMenu menu = new InlineMenu(base);
        rows.forEach((row) -> row.buttons.forEach((button) -> button.assignMenu(menu)));
        menu.rows = rows;
        return menu;
    }

    public T removeLast() {
        if (rows.size() != 0)
            rows.remove(rows.size() - 1);

        return instance();
    }
}
