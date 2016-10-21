package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.Content;
import pro.zackpollard.telegrambot.api.chat.message.content.ContentType;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;
import pro.zackpollard.telegrambot.api.utils.Utils;

/**
 * A prompt which ignores a message with a certain content type then proceeds to the next
 * @param <T> Accepting content type
 * @author Mazen Kotb
 */
public final class IgnoringPrompt<T extends Content> extends AbstractIgnoringPrompt<T> {
    private ContentType type;
    private SendableMessage promptMessage;

    private IgnoringPrompt(ContentType type, SendableMessage promptMessage) {
        Utils.validateNotNull(type);
        this.type = type;
        this.promptMessage = promptMessage;
    }

    /**
     * Creates new prompt
     * @param type The enum representation of T to accept
     * @param promptMessage The message to send before accepting input
     * @param <T> Accepting content type
     * @return New ignoring prompt
     */
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
