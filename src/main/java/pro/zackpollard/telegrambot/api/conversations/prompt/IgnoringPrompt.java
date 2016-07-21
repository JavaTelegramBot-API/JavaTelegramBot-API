package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.Content;
import pro.zackpollard.telegrambot.api.chat.message.content.ContentType;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;
import pro.zackpollard.telegrambot.api.utils.Utils;

public final class IgnoringPrompt<T extends Content> extends AbstractIgnoringPrompt<T> {
    private ContentType type;
    private SendableMessage promptMessage;

    private IgnoringPrompt(ContentType type, SendableMessage promptMessage) {
        Utils.validateNotNull(type);
        this.type = type;
        this.promptMessage = promptMessage;
    }

    public static <T extends Content> IgnoringPrompt<T> create(ContentType type, SendableMessage promptMessage) {
        return new IgnoringPrompt<>(type, promptMessage);
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
