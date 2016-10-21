package pro.zackpollard.telegrambot.api.menu;

import lombok.Getter;
import lombok.Setter;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableTextMessage;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardMarkup;
import pro.zackpollard.telegrambot.api.user.User;

import java.util.List;
import java.util.function.Predicate;

/**
 * An inline keyboard represented like a Menu.
 *
 * @author Mazen Kotb
 * @see InlineMenu#builder(TelegramBot)
 * @see InlineMenu#builder(TelegramBot, Chat)
 */
public class InlineMenu {
    @Getter
    private int internalId;
    @Getter
    Message baseMessage;
    @Getter
    @Setter
    private InlineMenu parent;
    Predicate<User> userPredicate;
    List<InlineMenuRow> rows;

    InlineMenu(Message baseMessage) {
        this.baseMessage = baseMessage;
    }

    /**
     * Create a new inline menu builder
     * @param bot The bot that will be used to send the message for this inline menu
     * @return new inline menu builder
     */
    public static InlineMenuBuilder builder(TelegramBot bot) {
        return new InlineMenuBuilder(bot);
    }

    /**
     * Creates new builder, initializes with the required Chat field
     * @param bot The bot that will be used to send the message for this inline menu
     * @param forWhom The chat the inline menu will be sent to
     * @return new inline menu builder initialized with the forWhom field
     */
    public static InlineMenuBuilder builder(TelegramBot bot, Chat forWhom) {
        return new InlineMenuBuilder(bot).forWhom(forWhom);
    }

    /**
     * Starts the inline menu, applies it's keyboard to the menu.
     * Registers itself as the menu used by the message
     *
     * @see InlineMenu#apply()
     * @see InlineMenuRegistry#register(InlineMenu)
     */
    public void start() {
        apply();
        baseMessage.getBotInstance().getInlineMenuRegistry().register(this);
    }

    /**
     * Disables listener of the menu. Removes from internal cache.
     *
     * @see InlineMenuRegistry#unregister(InlineMenu)
     */
    public void unregister() {
        baseMessage.getBotInstance().getInlineMenuRegistry().unregister(this);
    }

    /**
     * Returns row of specified index
     * @param index Index to get the row at
     * @return row
     * @throws IndexOutOfBoundsException if provided out of bounds index
     */
    public InlineMenuRow rowAt(int index) {
        return rows.get(index);
    }

    /**
     * Converts rows to the inline keyboard markup used by the Telegram API
     * @return keyboard markup
     */
    public InlineKeyboardMarkup toKeyboard() {
        InlineKeyboardMarkup.InlineKeyboardMarkupBuilder builder =
                InlineKeyboardMarkup.builder();

        if (rows.isEmpty()) {
            return null;
        }

        rows.stream().map(InlineMenuRow::toButtons).forEach(builder::addRow);
        return builder.build();
    }

    /**
     * Handle an inline query sent.
     * Caller dependent, throws exception if called from a class which doesn't implement InlineMenuRegistry
     *
     * @param query query to be processed
     * @param row row index
     * @param button button index
     *
     * @return Whether the menu handled the request, if not it was due to a user predicate or invalid row or invalid button
     * @see InlineMenuRegistry
     * @see InlineMenuRow#handle(CallbackQuery, int)
     */
    public boolean handle(CallbackQuery query, int row, int button) {
        if (!validateCaller(InlineMenuRegistry.class)) {
            throw new UnsupportedOperationException("Invalid caller! Caller must implement InlineMenuRegistry");
        }

        return (userPredicate == null || userPredicate.test(query.getFrom())) &&
                row < rows.size() && rowAt(row).handle(query, button);
    }

    /**
     * Apply any updates to the message
     */
    public void apply() {
        baseMessage.getBotInstance().editMessageReplyMarkup(baseMessage, toKeyboard());
    }

    /**
     * Set the text of the current message, updates keyboard
     * @param messageBuilder New Message text
     * @see InlineMenu#apply()
     */
    public void setMessageText(SendableTextMessage.SendableTextMessageBuilder messageBuilder) {
        SendableTextMessage message = messageBuilder.build();
        baseMessage.getBotInstance().editMessageText(baseMessage, message.getMessage(), message.getParseMode(),
                message.isDisableWebPagePreview(), toKeyboard());
    }

    // CALLER DEPENDENT
    // CALLER MUST IMPLEMENT INLINEMENUREGISTRY

    /**
     * Set the new internal id.
     * Caller dependent, throws exception if called from a class which doesn't implement InlineMenuRegistry
     *
     * @param newId Internal id
     * @see InlineMenuRegistry
     */
    public void setInternalId(int newId) {
        if (!validateCaller(InlineMenuRegistry.class)) {
            throw new UnsupportedOperationException("Invalid caller! Caller must implement InlineMenuRegistry");
        }

        this.internalId = newId;
    }

    private static boolean validateCaller(Class<?> intendedClass) {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        String rawFQN = stElements[3].toString().split("\\(")[0];
        Class<?> callingClass;

        try {
            callingClass = Class.forName(rawFQN.substring(0, rawFQN.lastIndexOf('.')));
        } catch (ClassNotFoundException ignored) {
            return false;
        }

        return intendedClass.isAssignableFrom(callingClass);
    }
}
