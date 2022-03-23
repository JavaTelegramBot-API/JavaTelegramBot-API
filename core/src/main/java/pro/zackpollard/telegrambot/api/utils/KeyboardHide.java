package pro.zackpollard.telegrambot.api.utils;

import com.mashape.unirest.request.body.MultipartBody;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.send.ReplyingOptions;
import pro.zackpollard.telegrambot.api.keyboards.ReplyKeyboardHide;

public class KeyboardHide implements ReplyOption {
    @Override
    public void multipartBodyField(MultipartBody multipartBody, ReplyingOptions replyingOptions) {
        if (replyingOptions.getReplyMarkup().getType().equals("KEYBOARD_HIDE")) {
            multipartBody.field("reply_markup", TelegramBot.GSON.toJson(replyingOptions.getReplyMarkup(), ReplyKeyboardHide.class), "application/json; charset=utf8;");
        }
    }
}
