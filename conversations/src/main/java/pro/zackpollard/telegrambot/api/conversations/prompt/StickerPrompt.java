package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.ContentType;
import pro.zackpollard.telegrambot.api.chat.message.content.StickerContent;
import pro.zackpollard.telegrambot.api.conversations.ConversationPrompt;

/**
 * Prompt which accepts a sticker as input
 * @author Mazen Kotb
 * @see StickerContent
 */
public abstract class StickerPrompt implements ConversationPrompt<StickerContent> {
    @Override
    public ContentType type() {
        return ContentType.STICKER;
    }
}
