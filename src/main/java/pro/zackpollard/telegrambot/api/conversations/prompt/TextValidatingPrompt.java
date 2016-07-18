package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;
import pro.zackpollard.telegrambot.api.conversations.ConversationPrompt;

public abstract class TextValidatingPrompt extends TextPrompt {
    protected abstract boolean validate(ConversationContext context, TextContent input);
    protected abstract ConversationPrompt accept(ConversationContext context, TextContent input);

    @Override
    public ConversationPrompt process(ConversationContext context, TextContent input) {
        if (validate(context, input)) {
            return accept(context, input);
        } else {
            SendableMessage message = invalidationMessage(context, input);

            if (message != null) {
                context.from().sendMessage(message);
            }

            return this; // try again loser
        }
    }

    protected SendableMessage invalidationMessage(ConversationContext context, TextContent input) {
        return null;
    }
}
