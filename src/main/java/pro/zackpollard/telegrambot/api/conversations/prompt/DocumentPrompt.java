package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.ContentType;
import pro.zackpollard.telegrambot.api.chat.message.content.DocumentContent;
import pro.zackpollard.telegrambot.api.conversations.ConversationPrompt;

public abstract class DocumentPrompt implements ConversationPrompt<DocumentContent> {
    @Override
    public ContentType type() {
        return ContentType.DOCUMENT;
    }
}
