package pro.zackpollard.telegrambot.api.conversations.prompt;

import pro.zackpollard.telegrambot.api.chat.message.content.ContentType;
import pro.zackpollard.telegrambot.api.chat.message.content.StickerContent;
import pro.zackpollard.telegrambot.api.conversations.ConversationPrompt;

public abstract class StickerPrompt implements ConversationPrompt<StickerContent> {
    @Override
    public ContentType type() {
        return ContentType.STICKER;
    }
}
