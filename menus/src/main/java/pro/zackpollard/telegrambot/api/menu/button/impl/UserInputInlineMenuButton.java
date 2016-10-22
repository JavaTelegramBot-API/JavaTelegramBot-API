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
import pro.zackpollard.telegrambot.api.menu.button.AbstractInlineMenuButton;
import pro.zackpollard.telegrambot.api.menu.button.InlineMenuButton;

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

    public UserInputInlineMenuButton(InlineMenu owner, int row, int num, String text, BiConsumer<InlineMenuButton, String> textCallback) {
        super(owner, row, num, text);
        this.textCallback = textCallback;
    }

    public UserInputInlineMenuButton(InlineMenu owner, int row, int num, BiConsumer<InlineMenuButton, String> textCallback) {
        super(owner, row, num);
        this.textCallback = textCallback;
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
