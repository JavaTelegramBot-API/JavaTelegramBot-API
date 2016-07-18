package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.Content;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;
import pro.zackpollard.telegrambot.api.conversations.ConversationPrompt;

public abstract class AbstractIgnoringPrompt<T extends Content> implements ConversationPrompt<T> {
    private final ConversationPrompt nextPrompt;

    protected AbstractIgnoringPrompt(ConversationPrompt nextPrompt) {
        this.nextPrompt = nextPrompt;
    }

    @Override
    public ConversationPrompt process(ConversationContext context, T input) {
        return nextPrompt;
    }
}
