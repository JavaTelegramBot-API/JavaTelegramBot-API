package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.ContentType;
import pro.zackpollard.telegrambot.api.chat.message.content.LocationContent;
import pro.zackpollard.telegrambot.api.conversations.ConversationPrompt;

/**
 * A prompt which accepts locations
 * @author Mazen Kotb
 * @see LocationContent
 */
public abstract class LocationPrompt implements ConversationPrompt<LocationContent> {
    @Override
    public ContentType type() {
        return ContentType.LOCATION;
    }
}
