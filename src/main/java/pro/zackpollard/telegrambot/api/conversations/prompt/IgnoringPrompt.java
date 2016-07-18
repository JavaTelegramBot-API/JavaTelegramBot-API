package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.Content;
import pro.zackpollard.telegrambot.api.chat.message.content.ContentType;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;
import pro.zackpollard.telegrambot.api.conversations.ConversationPrompt;
import pro.zackpollard.telegrambot.api.utils.Utils;

public final class IgnoringPrompt<T extends Content> extends AbstractIgnoringPrompt<T> {
    private ContentType type;
    private SendableMessage promptMessage;

    private IgnoringPrompt(ConversationPrompt nextPrompt, ContentType type, SendableMessage promptMessage) {
        super(nextPrompt);
        Utils.validateNotNull(nextPrompt, type);
        this.type = type;
        this.promptMessage = promptMessage;
    }

    public static <T extends Content> IgnoringPrompt<T> create(ConversationPrompt nextPrompt, ContentType type, SendableMessage promptMessage) {
        return new IgnoringPrompt<>(nextPrompt, type, promptMessage);
    }

    @Override
    public ContentType type() {
        return type;
    }

    @Override
    public SendableMessage promptMessage(ConversationContext context) {
        return promptMessage;
    }
}
