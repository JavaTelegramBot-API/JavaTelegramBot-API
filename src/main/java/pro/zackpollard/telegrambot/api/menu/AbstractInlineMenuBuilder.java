package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Abstract menu builder, shared methods between sub menus and head menus.
 *
 * Supports rows and user predicates.
 *
 * @param <T> Implementing class
 * @author Mazen Kotb
 */
public abstract class AbstractInlineMenuBuilder<T extends AbstractInlineMenuBuilder> {
    List<InlineMenuRow> rows = new ArrayList<>();
    Predicate<User> userPredicate;

    /**
     * Create a new row
     * @return new row builder
     */
    public InlineMenuRowBuilder<T> newRow() {
        return new InlineMenuRowBuilder<>(instance(), rows.size());
    }

    /**
     * Build the menu
     * @return Built menu
     */
    public abstract InlineMenu buildMenu();

    /**
     * Return current instance. Used for non-abstract builder methods
     * @return 'this'
     */
    protected abstract T instance();

    /**
     * Build a menu from message base.
     * Adds &amp; Registers all buttons.
     * Applies user predicate.
     * Applies rows.
     *
     * @param base Message
     * @return built menu
     */
    protected InlineMenu buildMenu(Message base) {
        InlineMenu menu = new InlineMenu(base);
        rows.forEach((row) -> row.buttons.forEach((button) -> button.assignMenu(menu)));
        menu.userPredicate = userPredicate;
        menu.rows = rows;
        return menu;
    }

    /**
     * Remove the last row.
     *
     * @return this
     */
    public T removeLast() {
        if (rows.size() != 0)
            rows.remove(rows.size() - 1);

        return instance();
    }

    /**
     * Add a user filter to the menu.
     * Predicate is called before any buttons are called, if returned true
     * the button will be called, otherwise it won't
     *
     * @param predicate user filter
     * @return this
     */
    public T userFilter(Predicate<User> predicate) {
        this.userPredicate = predicate;
        return instance();
    }

    /**
     * Allow a list of users to use this menu
     * @param users Allowed users
     * @return this
     */
    public T allowedUsers(User... users) {
        List<User> usersList = Arrays.asList(users);
        this.userPredicate = (user) -> usersList.stream()
                .anyMatch((allowedUser) -> allowedUser.getId() == user.getId());
        return instance();
    }

    /**
     * Allow a single user to use this menu
     * @param allowedUser allowed user
     * @return this
     */
    public T allowedUser(User allowedUser) {
        this.userPredicate = (user) -> user.getId() == allowedUser.getId();
        return instance();
    }

    /**
     * Allow a list of users to use this menu
     * @param userIds allows user ids
     * @return this
     */
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

    /**
     * Allow a single user to use this menu
     * @param userId the id of said user
     * @return this
     */
    public T allowedUser(long userId) {
        this.userPredicate = (user) -> user.getId() == userId;
        return instance();
    }
}
