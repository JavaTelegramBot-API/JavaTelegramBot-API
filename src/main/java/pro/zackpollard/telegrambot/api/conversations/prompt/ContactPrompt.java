package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.ContactContent;
import pro.zackpollard.telegrambot.api.chat.message.content.ContentType;
import pro.zackpollard.telegrambot.api.conversations.ConversationPrompt;

public abstract class ContactPrompt implements ConversationPrompt<ContactContent> {
    @Override
    public ContentType type() {
        return ContentType.CONTACT;
    }
}
