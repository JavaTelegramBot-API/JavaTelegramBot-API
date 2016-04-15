package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.StickerContent;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Sticker;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.StickerImpl;

/**
 * @author Zack Pollard
 */
public class StickerContentImpl implements StickerContent {

    private final Sticker content;

    private StickerContentImpl(JSONObject jsonObject) {

        this.content = StickerImpl.createSticker(jsonObject);
    }

    public static StickerContent createStickerContent(JSONObject jsonObject) {

        return jsonObject != null ? new StickerContentImpl(jsonObject) : null;
    }

    @Override
    public Sticker getContent() {
        return content;
    }
}
