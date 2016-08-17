package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;

/**
 * This prompt validates text using an abstract method.
 *
 * @author Mazen Kotb
 */
public abstract class TextValidatingPrompt extends TextPrompt {
    /**
     * Validate text input
     * @param context The context of the conversation
     * @param input User input
     * @return whether or not the text is valid
     */
    protected abstract boolean validate(ConversationContext context, TextContent input);

    /**
     * Accept text input
     * @param context The context of the conversation
     * @param input User input
     * @return Whether or not to repeat the current prompt
     */
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

    /**
     * Optional. Message sent when inputted text is invalid.
     * promptMessage() will still be called. Null is accepted.
     *
     * @param context The context of the conversation
     * @param input User input
     * @return invalidation message, null is allowed
     * @see pro.zackpollard.telegrambot.api.conversations.ConversationPrompt#promptMessage(ConversationContext)
     */
    protected SendableMessage invalidationMessage(ConversationContext context, TextContent input) {
        return null;
    }
}
