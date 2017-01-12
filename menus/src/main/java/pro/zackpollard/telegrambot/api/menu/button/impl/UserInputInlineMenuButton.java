package pro.zackpollard.telegrambot.api.menu.button.impl;

import lombok.Getter;
import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.conversations.Conversation;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;
import pro.zackpollard.telegrambot.api.conversations.prompt.TextPrompt;
import pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardButton;
import pro.zackpollard.telegrambot.api.menu.InlineMenu;
import pro.zackpollard.telegrambot.api.menu.InlineMenuBuilder;
import pro.zackpollard.telegrambot.api.menu.button.AbstractInlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.builder.UserInputInlineMenuButtonBuilder;

import java.util.function.BiConsumer;

/**
 * Button which after being called listens for user input.
 *
 * @author Mazen Kotb
 */
public class UserInputInlineMenuButton extends AbstractInlineMenuButton {
    @Getter
    private final BiConsumer<InlineMenuButton, String> textCallback;
    private boolean inputGiven = true;

    public UserInputInlineMenuButton(InlineMenu owner, int row, String text, BiConsumer<InlineMenuButton, String> textCallback) {
        super(owner, row, text);
        this.textCallback = textCallback;
    }

    public UserInputInlineMenuButton(InlineMenu owner, int row, BiConsumer<InlineMenuButton, String> textCallback) {
        super(owner, row);
        this.textCallback = textCallback;
    }

    @Deprecated
    public UserInputInlineMenuButton(InlineMenu owner, int row, int num, String text, BiConsumer<InlineMenuButton, String> textCallback) {
        this(owner, row, text, textCallback);
    }

    @Deprecated
    public UserInputInlineMenuButton(InlineMenu owner, int row, int num, BiConsumer<InlineMenuButton, String> textCallback) {
        this(owner, row, textCallback);
    }

    public static UserInputInlineMenuButtonBuilder builder() {
        return new UserInputInlineMenuButtonBuilder<InlineMenuBuilder>(null);
    }

    public static UserInputInlineMenuButtonBuilder builder(String text) {
        return new UserInputInlineMenuButtonBuilder<InlineMenuBuilder>(null, text);
    }

    @Override
    public InlineKeyboardButton toKeyboardButton() {
        return keyboardBuilder().build();
    }

    /**
     * Initiates a conversation with the chat awaiting text input
     * On input executes callback
     *
     * @param query unused
     * @see Conversation
     * @see TextPrompt
     */
    @Override
    public void handlePress(CallbackQuery query) {
        executeCallback();

        if (textCallback != null && inputGiven) {
            inputGiven = false;

            Conversation.builder(query.getBotInstance())
                    .forWhom(owner.getBaseMessage().getChat())
                    .silent(true)
                    .prompts().last(new TextPrompt() {
                @Override
                public boolean process(ConversationContext context, TextContent input) {
                    textCallback.accept(UserInputInlineMenuButton.this, input.getContent());
                    inputGiven = true;
                    return false;
                }

                @Override
                public SendableMessage promptMessage(ConversationContext context) {
                    return null;
                }
            }).build().begin();
        }
    }
}
