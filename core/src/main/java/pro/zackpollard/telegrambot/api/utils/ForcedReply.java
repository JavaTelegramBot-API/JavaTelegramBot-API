package pro.zackpollard.telegrambot.api.utils;

import com.mashape.unirest.request.body.MultipartBody;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.send.ReplyingOptions;

public class ForcedReply implements ReplyOption {
    @Override
    public void multipartBodyField(MultipartBody multipartBody, ReplyingOptions replyingOptions) {
        if (replyingOptions.getReplyMarkup().getType().equals("FORCE_REPLY")) {
            multipartBody.field("reply_markup", TelegramBot.GSON.toJson(replyingOptions.getReplyMarkup(), pro.zackpollard.telegrambot.api.chat.message.ForceReply.class), "application/json; charset=utf8;");
        }
    }
}
