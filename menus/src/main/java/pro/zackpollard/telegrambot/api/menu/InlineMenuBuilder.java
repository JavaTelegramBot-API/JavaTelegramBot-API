package pro.zackpollard.telegrambot.api.menu;

import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableTextMessage.SendableTextMessageBuilder;
import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder for main menus, allows creation of sub menus.
 *
 * @author Mazen Kotb
 */
public class InlineMenuBuilder extends AbstractInlineMenuBuilder<InlineMenuBuilder> {
    private final TelegramBot bot;
    private Chat forWhom;
    private SendableTextMessageBuilder messageBuilder;
    private Message message;
    List<InlineMenu> subs = new ArrayList<>();

    InlineMenuBuilder(TelegramBot bot) {
        this.bot = bot;
    }

    /**
     * REQUIRED OR message(Message). Set message to be used
     * @param builder Message to be used
     * @return this
     */
    public InlineMenuBuilder message(SendableTextMessageBuilder builder) {
        this.messageBuilder = builder;
        return this;
    }

    /**
     * REQUIRED OR message(SendableTextMessageBuilder). Set message to be used
     * @param baseMessage Message to be used
     * @return this
     */
    public InlineMenuBuilder message(Message baseMessage) {
        this.message = baseMessage;
        return this;
    }

    /**
     * REQUIRED. Set the chat for this menu to be used by
     * @param chat Owning chat
     * @return this
     */
    public InlineMenuBuilder forWhom(Chat chat) {
        this.forWhom = chat;
        return this;
    }

    /**
     * Create a sub menu to be called upon later from a button
     * @return new sub menu builder
     */
    public SubInlineMenuBuilder subMenu() {
        SubInlineMenuBuilder sub = new SubInlineMenuBuilder(this);
        sub.userPredicate = userPredicate;
        return sub;
    }

    @Override
    protected InlineMenuBuilder instance() {
        return this;
    }

    @Override
    public InlineMenu buildMenu() {
        Message baseMessage = message != null ? message : bot.sendMessage(forWhom, messageBuilder.build());
        InlineMenu menu = buildMenu(baseMessage);

        subs.forEach((sub) -> {
            sub.baseMessage = baseMessage;
            sub.setParent(menu);
        });

        return menu;
    }
}
