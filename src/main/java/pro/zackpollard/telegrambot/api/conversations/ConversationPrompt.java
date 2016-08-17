package pro.zackpollard.telegrambot.api.conversations;

import pro.zackpollard.telegrambot.api.chat.message.content.Content;
import pro.zackpollard.telegrambot.api.chat.message.content.ContentType;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;

/**
 * An element to a conversation, accepts a specific content type.
 * @param <T> Accepting content type
 * @author Mazen Kotb
 */
public interface ConversationPrompt<T extends Content> {
    /**
     * The content type representation of type T.
     * @return Content type
     */
    ContentType type();

    /**
     * Processes input from user
     * @param context The context of the conversation
     * @param input Input message from user
     * @return Whether to repeat the prompt or not
     */
    boolean process(ConversationContext context, T input);

    /**
     * The message sent before accepting input. Not called if conversation is silent.
     * @param context Context of the conversation
     * @return Message sent before accepting input
     */
    SendableMessage promptMessage(ConversationContext context);

    /**
     * Called when the conversation has ended, either naturally or forcibly using the end method.
     * @param context The context of the conversation
     * @see Conversation#end()
     */
    default void conversationEnded(ConversationContext context) {
    }
}
