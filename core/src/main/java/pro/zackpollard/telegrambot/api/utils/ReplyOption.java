package pro.zackpollard.telegrambot.api.utils;

import com.mashape.unirest.request.body.MultipartBody;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.send.ReplyingOptions;
import pro.zackpollard.telegrambot.api.keyboards.ReplyKeyboardHide;
import pro.zackpollard.telegrambot.api.keyboards.ReplyKeyboardMarkup;
import pro.zackpollard.telegrambot.api.keyboards.ReplyKeyboardRemove;

public interface ReplyOption {
    public void multipartBodyField(MultipartBody multipartBody, ReplyingOptions replyingOptions);
}

