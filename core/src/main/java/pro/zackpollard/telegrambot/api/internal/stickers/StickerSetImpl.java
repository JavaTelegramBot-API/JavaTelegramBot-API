package pro.zackpollard.telegrambot.api.internal.stickers;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.ChatPhoto;
import pro.zackpollard.telegrambot.api.chat.SuperGroupChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Sticker;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.internal.chat.ChatPhotoImpl;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.StickerImpl;
import pro.zackpollard.telegrambot.api.stickers.StickerSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class StickerSetImpl implements StickerSet {

    private final String name;
    private final String title;
    private final boolean contains_masks;
    private final List<Sticker> stickers;

    private final TelegramBot telegramBot;

    private StickerSetImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.name = jsonObject.getString("name");
        this.title = jsonObject.getString("title");
        this.contains_masks = jsonObject.getBoolean("contains_masks");
        this.stickers = new ArrayList<>();

        JSONArray jsonStickers = jsonObject.getJSONArray("stickers");

        if(jsonStickers != null) {
            for(int i = 0; i < jsonStickers.length(); ++i) {
                JSONObject jsonSticker = jsonStickers.getJSONObject(i);
                this.stickers.add(StickerImpl.createSticker(jsonSticker));
            }
        }

        this.telegramBot = telegramBot;
    }

    public static StickerSet createStickerSet(JSONObject jsonObject, TelegramBot telegramBot) {

        return new StickerSetImpl(jsonObject, telegramBot);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isContainsMasks() {
        return contains_masks;
    }

    @Override
    public List<Sticker> getStickers() {
        return stickers;
    }

    @Override
    public TelegramBot getBotInstance() {
        return telegramBot;
    }
}