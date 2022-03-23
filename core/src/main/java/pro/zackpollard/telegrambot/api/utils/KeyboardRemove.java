package pro.zackpollard.telegrambot.api.utils;

import com.mashape.unirest.request.body.MultipartBody;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.send.ReplyingOptions;
import pro.zackpollard.telegrambot.api.keyboards.ReplyKeyboardRemove;

public class KeyboardRemove implements ReplyOption {
    @Override
    public void multipartBodyField(MultipartBody multipartBody, ReplyingOptions replyingOptions) {
        if (replyingOptions.getReplyMarkup().getType().equals("KEYBOARD_REMOVE")) {
            multipartBody.field("reply_markup", TelegramBot.GSON.toJson(replyingOptions.getReplyMarkup(), ReplyKeyboardRemove.class), "application/json; charset=utf8;");
        }
    }
}
