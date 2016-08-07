package pro.zackpollard.telegrambot.api.menu;

import lombok.Getter;
import lombok.Setter;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardMarkup;
import pro.zackpollard.telegrambot.api.user.User;

import java.util.List;
import java.util.function.Predicate;

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

    public static InlineMenuBuilder builder(TelegramBot bot) {
        return new InlineMenuBuilder(bot);
    }

    public static InlineMenuBuilder builder(TelegramBot bot, Chat forWhom) {
        return new InlineMenuBuilder(bot).forWhom(forWhom);
    }

    public void start() {
        apply();
        baseMessage.getBotInstance().getInlineMenuRegistry().register(this);
    }

    public void unregister() {
        baseMessage.getBotInstance().getInlineMenuRegistry().unregister(this);
    }

    public InlineMenuRow rowAt(int index) {
        return rows.get(index);
    }

    public InlineKeyboardMarkup toKeyboard() {
        InlineKeyboardMarkup.InlineKeyboardMarkupBuilder builder =
                InlineKeyboardMarkup.builder();

        if (rows.isEmpty()) {
            return null;
        }

        rows.stream().map(InlineMenuRow::toButtons).forEach(builder::addRow);
        return builder.build();
    }

    public boolean handle(CallbackQuery query, int row, int button) {
        return (userPredicate == null || userPredicate.test(query.getFrom())) &&
                row < rows.size() && rowAt(row).handle(query, button);
    }

    public void apply() {
        baseMessage.getBotInstance().editMessageReplyMarkup(baseMessage, toKeyboard());
    }

    // CALLER DEPENDENT
    // CALLER MUST IMPLEMENT INLINEMENUREGISTRY
    public void setInternalId(int newId) {
        if (!validateCaller(InlineMenuRegistry.class)) {
            throw new UnsupportedOperationException("Invalid caller! Caller must implement InlineMenuRegistry");
        }

        this.internalId = newId;
    }

    private boolean validateCaller(Class<?> intendedClass) {
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
