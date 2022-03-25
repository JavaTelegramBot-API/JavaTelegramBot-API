package pro.zackpollard.telegrambot.api.conversations;

import pro.zackpollard.telegrambot.api.chat.message.Message;

import java.util.LinkedList;
import java.util.List;

/**
 * Simple holder for the history of a conversation
 * @author Mazen Kotb
 */
public final class ConversationHistory {
    final List<Long> sentMessages = new LinkedList<>();
    final List<Message> history = new LinkedList<>();

    private ConversationHistory() {
    }

    static ConversationHistory create() {
        return new ConversationHistory();
    }

    /**
     * Gets the first message sent by the other member
     * @throws IndexOutOfBoundsException if there are no messages
     * @return The first message sent by the other member
     */
    public Message firstMessage() {
        return history.get(0);
    }

    /**
     * Gets message at the provided index
     * @param index Index of the message
     * @return Message at index
     * @throws IndexOutOfBoundsException if there are no messages
     */
    public Message messageAt(int index) {
        return history.get(index);
    }

    /**
     * Gets message sent at specified prompt
     * @param prompt Prompt identifier
     * @param conversation Conversation prompt is used in
     * @return message sent at specified prompt
     * @throws IndexOutOfBoundsException if there are no messages from that prompt
     */
    public Message messageAtPrompt(ConversationPrompt prompt, Conversation conversation) {
        return messageAt(conversation.getPrompts().indexOf(prompt));
    }


    /**
     * Gets the last message sent
     * @return last message sent
     * @throws IndexOutOfBoundsException if there are no messages
     */
    public Message lastMessage() {
        if (history.isEmpty()) {
            return null;
        }

        return history.get(history.size() - 1);
    }
}
