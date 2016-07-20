package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;

public abstract class TextValidatingPrompt extends TextPrompt {
    protected abstract boolean validate(ConversationContext context, TextContent input);
    protected abstract boolean accept(ConversationContext context, TextContent input);

    @Override
    public boolean process(ConversationContext context, TextContent input) {
        if (validate(context, input)) {
            return accept(context, input);
        } else {
            SendableMessage message = invalidationMessage(context, input);

            if (message != null) {
                context.getFrom().sendMessage(message);
            }

            return true; // try again loser
        }
    }

    protected SendableMessage invalidationMessage(ConversationContext context, TextContent input) {
        return null;
    }
}
