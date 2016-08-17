package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.StickerContent;

/**
 * @author Zack Pollard
 */
public class StickerMessageReceivedEvent extends MessageReceivedEvent {

    public StickerMessageReceivedEvent(Message message) {

        super(message);
    }

    /**
     * Gets the Sticker that was received that triggered this Event
     *
     * @return The Sticker that was received that triggered this Event
     */
    @Override
    public StickerContent getContent() {

        return (StickerContent) getMessage().getContent();
    }
}