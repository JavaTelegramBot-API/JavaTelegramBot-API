package pro.zackpollard.telegrambot.api.conversations;

import pro.zackpollard.telegrambot.api.chat.message.Message;

import java.util.ArrayList;
import java.util.List;

public final class ConversationHistory {
    final List<Message> history = new ArrayList<>();

    private ConversationHistory() {
    }

    static ConversationHistory create() {
        return new ConversationHistory();
    }

    public Message first() {
        return history.get(0);
    }

    public Message messageAt(int index) {
        return history.get(index);
    }

    public Message last() {
        if (history.isEmpty()) {
            return null;
        }

        return history.get(history.size() - 1);
    }
}
