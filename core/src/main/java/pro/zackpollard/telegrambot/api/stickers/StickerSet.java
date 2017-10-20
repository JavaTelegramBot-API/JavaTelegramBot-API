package pro.zackpollard.telegrambot.api.stickers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.body.MultipartBody;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Sticker;
import pro.zackpollard.telegrambot.api.chat.message.send.InputFile;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.StickerImpl;
import pro.zackpollard.telegrambot.api.internal.stickers.StickerSetImpl;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.util.List;

public interface StickerSet {

    String getName();

    String getTitle();

    boolean isContainsMasks();

    List<Sticker> getStickers();

    TelegramBot getBotInstance();

    /**
     * Use this method to get a sticker set. On success, a StickerSet object is returned
     *
     * @param instance  The TelegramBot instance that you are using to call this method
     * @param name      The name of the sticker set that you want to retrieve
     *
     * @return A StickerSet object, or null if the fetch failed
     */
    static StickerSet getStickerSet(TelegramBot instance, String name) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "getStickerSet")
                    .field("name", name);

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                return StickerSetImpl.createStickerSet(jsonResponse.getJSONObject("result"), instance);
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Use this method to upload a .png file with a sticker for later use in createNewStickerSet and addStickerToSet
     * methods (can be used multiple times). Returns the uploaded File on success
     *
     * @param instance      The TelegramBot instance that you are using to call this method
     * @param userId        User identifier of sticker file owner
     * @param pngSticker    Png image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed
     *                      512px, and either width or height must be exactly 512px
     *
     * @return A Sticker object, or null if the upload failed
     */
    static Sticker uploadStickerFile(TelegramBot instance, long userId, InputFile pngSticker) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "uploadStickerFile")
                    .field("user_id", userId);

            Utils.processInputFileField(request, "png_sticker", pngSticker);

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if (jsonResponse != null) {

                return StickerImpl.createSticker(jsonResponse.getJSONObject("result"));
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Use this method to create new sticker set owned by a user. The bot will be able to edit the created sticker set
     *
     * @param instance      The TelegramBot instance that you are using to call this method
     * @param userId        User identifier of created sticker set owner
     * @param name          Short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain
     *                      only english letters, digits and underscores. Must begin with a letter, can't contain
     *                      consecutive underscores and must end in “_by_(bot_username)”. (bot_username) is case
     *                      insensitive. 1-64 characters.
     * @param title         Sticker set title, 1-64 characters
     * @param containsMasks Pass True if a set of mask stickers should be created
     * @param sticker       A CreatableSticker object to be used as the first sticker in the StickerSet
     *
     * @return True if sticker set was created successfully, False otherwise
     */
    static boolean createNewStickerSet(TelegramBot instance, long userId, String name, String title, boolean containsMasks, CreatableSticker sticker) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "createNewStickerSet")
                    .field("user_id", userId)
                    .field("name", name, "application/json; charset=utf8;")
                    .field("title", title, "application/json; charset=utf8;")
                    .field("emojis", sticker.getEmojis(), "application/json; charset=utf8;")
                    .field("contains_masks", containsMasks)
                    .field("mask_position", TelegramBot.GSON.toJson(sticker.getMaskPosition(), MaskPosition.class), "application/json; charset=utf8;");

            if(sticker.getPngSticker() != null) {
                Utils.processInputFileField(request, "png_sticker", sticker.getPngSticker());
            } else {
                request.field("png_sticker", sticker.getPngStickerUrl());
            }

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to add a new sticker to a set created by the bot
     *
     * @param instance      The TelegramBot instance that you are using to call this method
     * @param userId        User identifier of created sticker set owner
     * @param name          Sticker set name
     * @param sticker       A CreatableSticker object to be used as the first sticker in the StickerSet
     *
     * @return True if sticker was added to the set successfully, False otherwise
     */
    static boolean addStickerToSet(TelegramBot instance, long userId, String name, CreatableSticker sticker) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "addStickerToSet")
                    .field("user_id", userId)
                    .field("name", name, "application/json; charset=utf8;")
                    .field("emojis", sticker.getEmojis(), "application/json; charset=utf8;")
                    .field("mask_position", TelegramBot.GSON.toJson(sticker.getMaskPosition(), MaskPosition.class), "application/json; charset=utf8;");

            if(sticker.getPngSticker() != null) {
                Utils.processInputFileField(request, "png_sticker", sticker.getPngSticker());
            } else {
                request.field("png_sticker", sticker.getPngStickerUrl());
            }

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to move a sticker in a set created by the bot to a specific position
     *
     * @param instance  The TelegramBot instance that you are using to call this method
     * @param stickerId File identifier of the sticker
     * @param position  New sticker position in the set, zero-based
     *
     * @return True if sticker position was set successfully, False otherwise
     */
    static boolean setStickerPositionInSet(TelegramBot instance, String stickerId, int position) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "setStickerPositionInSet")
                    .field("sticker", stickerId, "application/json; charset=utf8;")
                    .field("position", position);

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Use this method to delete a sticker from a set created by the bot
     *
     * @param instance  The TelegramBot instance that you are using to call this method
     * @param stickerId File identifier of the sticker
     *
     * @return True if sticker was deleted from the set successfully, False otherwise
     */
    static boolean deleteStickerFromSet(TelegramBot instance, String stickerId) {

        HttpResponse<String> response;
        JSONObject jsonResponse;

        try {
            MultipartBody request = Unirest.post(instance.getBotAPIUrl() + "deleteStickerFromSet")
                    .field("sticker", stickerId, "application/json; charset=utf8;");

            response = request.asString();
            jsonResponse = Utils.processResponse(response);

            if(jsonResponse != null) {

                if(jsonResponse.getBoolean("result")) return true;
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return false;
    }
}