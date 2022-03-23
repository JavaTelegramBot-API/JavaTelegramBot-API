
package pro.zackpollard.telegrambot.api.utils;

import com.mashape.unirest.request.body.MultipartBody;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.send.ReplyingOptions;

public class InlinedKeyboardMarkup implements ReplyOption {
    @Override
    public void multipartBodyField(MultipartBody multipartBody, ReplyingOptions replyingOptions) {
        if (replyingOptions.getReplyMarkup().getType().equals("INLINE_KEYBOARD_MARKUP")) {
            multipartBody.field("reply_markup", TelegramBot.GSON.toJson(replyingOptions.getReplyMarkup(), pro.zackpollard.telegrambot.api.keyboards.InlineKeyboardMarkup.class), "application/json; charset=utf8;");
        }
    }
}