package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.ContentType;
import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.conversations.ConversationPrompt;

public abstract class TextPrompt implements ConversationPrompt<TextContent> {
    @Override
    public ContentType type() {
        return ContentType.TEXT;
    }
}
