package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;

import java.util.regex.Pattern;

public interface InlineMenuRegistry {
    Pattern DATA_PATTERN = Pattern.compile("^im\\.(\\d+)\\.(\\d+)\\.(\\d+)$");

    void register(InlineMenu menu);
    void unregister(InlineMenu menu);
    boolean process(CallbackQuery query);
}
