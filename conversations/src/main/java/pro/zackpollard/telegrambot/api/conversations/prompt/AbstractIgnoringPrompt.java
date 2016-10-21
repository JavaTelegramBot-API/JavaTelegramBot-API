package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.Content;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;
import pro.zackpollard.telegrambot.api.conversations.ConversationPrompt;

/**
 * Ignoring prompt, will not repeat. Ignores whatever message sent to it
 *
 * @param <T> Accepting content type
 * @author Mazen Kotb
 */
public abstract class AbstractIgnoringPrompt<T extends Content> implements ConversationPrompt<T> {
    protected AbstractIgnoringPrompt() {
    }

    @Override
    public boolean process(ConversationContext context, T input) {
        return false;
    }
}
