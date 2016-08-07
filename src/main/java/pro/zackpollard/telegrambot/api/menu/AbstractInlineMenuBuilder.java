package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractInlineMenuBuilder<T extends AbstractInlineMenuBuilder> {
    List<InlineMenuRow> rows = new ArrayList<>();
    Predicate<User> userPredicate;

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

    public T userFilter(Predicate<User> predicate) {
        this.userPredicate = predicate;
        return instance();
    }

    public T allowedUsers(User... users) {
        List<User> usersList = Arrays.asList(users);
        this.userPredicate = (user) -> usersList.stream()
                .anyMatch((allowedUser) -> allowedUser.getId() == user.getId());
        return instance();
    }

    public T allowedUser(User allowedUser) {
        this.userPredicate = (user) -> user.getId() == allowedUser.getId();
        return instance();
    }

    public T allowedUsers(long... userIds) {
        this.userPredicate = (user) -> {
            for (long id : userIds) {
                if (id == user.getId()) {
                    return true;
                }
            }

            return false;
        };
        return instance();
    }

    public T allowedUser(long userId) {
        this.userPredicate = (user) -> user.getId() == userId;
        return instance();
    }
}
