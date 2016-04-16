package pro.zackpollard.telegrambot.api.chat;

import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableTextMessage;

/**
 * @author Zack Pollard
 */
public interface Chat {

    String getId();

    String getName();

    ChatType getType();

    TelegramBot getBotInstance();

    default Message sendMessage(String message) {

        return this.sendMessage(SendableTextMessage.builder().message(message).build());
    }

    Message sendMessage(SendableMessage message);
}