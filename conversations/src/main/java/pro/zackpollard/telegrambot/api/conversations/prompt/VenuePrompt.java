package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.ContentType;
import pro.zackpollard.telegrambot.api.chat.message.content.VenueContent;
import pro.zackpollard.telegrambot.api.conversations.ConversationPrompt;

/**
 * A prompt which accepts a venue as input.
 * @author Mazen Kotb
 * @see VenueContent
 */
public abstract class VenuePrompt implements ConversationPrompt<VenueContent> {
    @Override
    public ContentType type() {
        return ContentType.VENUE;
    }
}
