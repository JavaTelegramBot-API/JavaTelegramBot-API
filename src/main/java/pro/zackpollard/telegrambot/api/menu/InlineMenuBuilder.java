package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableTextMessage.SendableTextMessageBuilder;

import java.util.ArrayList;
import java.util.List;

public class InlineMenuBuilder extends AbstractInlineMenuBuilder<InlineMenuBuilder> {
    private final TelegramBot bot;
    private Chat forWhom;
    private SendableTextMessageBuilder message;
    List<InlineMenu> subs = new ArrayList<>();

    InlineMenuBuilder(TelegramBot bot) {
        this.bot = bot;
    }

    public InlineMenuBuilder message(SendableTextMessageBuilder builder) {
        this.message = builder;
        return this;
    }

    public InlineMenuBuilder forWhom(Chat chat) {
        this.forWhom = chat;
        return this;
    }

    public SubInlineMenuBuilder subMenu() {
        return new SubInlineMenuBuilder(this);
    }

    @Override
    protected InlineMenuBuilder instance() {
        return this;
    }

    public InlineMenu build() {
        Message baseMessage = bot.sendMessage(forWhom, message.build());
        InlineMenu menu = buildMenu(baseMessage);

        subs.forEach((sub) -> {
            sub.baseMessage = baseMessage;
            sub.setParent(menu);
        });

        return menu;
    }
}
