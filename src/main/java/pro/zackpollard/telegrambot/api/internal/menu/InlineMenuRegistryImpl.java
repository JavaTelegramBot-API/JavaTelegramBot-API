package pro.zackpollard.telegrambot.api.internal.menu;

import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.InlineMenuRegistry;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;

public class InlineMenuRegistryImpl implements InlineMenuRegistry {
    private final AtomicInteger nextId = new AtomicInteger(0);
    private final Map<Integer, InlineMenu> menus = new ConcurrentHashMap<>();

    private InlineMenuRegistryImpl() {
    }

    public static InlineMenuRegistryImpl create() {
        return new InlineMenuRegistryImpl();
    }

    @Override
    public void register(InlineMenu menu) {
        int next = nextId.get();

        menus.put(next, menu);
        menu.setInternalId(next);

        updateNextId();
    }

    @Override
    public void unregister(InlineMenu menu) {
        menus.remove(menu.getInternalId());
        updateNextId();
    }

    @Override
    public boolean process(CallbackQuery query) {
        String data = query.getData();
        Matcher matcher = DATA_PATTERN.matcher(data);

        if (!matcher.find()) {
            return false;
        }

        InlineMenu menu = menus.get(Integer.parseInt(matcher.group(1)));

        return menu != null &&
                menu.handle(query, Integer.parseInt(matcher.group(2)),
                        Integer.parseInt(matcher.group(3)));
    }

    private void updateNextId() {
        int selectedId = -1;
        Set<Integer> usedIds = menus.keySet();

        for (int i = 0; selectedId == -1; i++) {
            if (!usedIds.contains(i))
                selectedId = i;
        }

        nextId.set(selectedId);
    }
}
