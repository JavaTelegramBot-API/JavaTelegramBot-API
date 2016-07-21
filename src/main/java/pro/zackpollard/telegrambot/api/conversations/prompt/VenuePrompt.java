package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.ContentType;
import pro.zackpollard.telegrambot.api.chat.message.content.VenueContent;
import pro.zackpollard.telegrambot.api.conversations.ConversationPrompt;

public abstract class VenuePrompt implements ConversationPrompt<VenueContent> {
    @Override
    public ContentType type() {
        return ContentType.VENUE;
    }
}
