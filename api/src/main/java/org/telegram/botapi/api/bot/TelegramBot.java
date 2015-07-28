package org.telegram.botapi.api.bot;

import lombok.NonNull;
import org.telegram.botapi.api.BotServer;
import org.telegram.botapi.api.TelegramBotAPI;
import org.telegram.botapi.api.chat.Chat;
import org.telegram.botapi.api.chat.message.Message;
import org.telegram.botapi.api.chat.message.send.SendableMessage;
import org.telegram.botapi.api.chat.message.send.SendableTextMessage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zack Pollard
 */
public interface TelegramBot {

    default void onEnable() {
    }
    default void onDisable() {
    }

    default Message sendMessage(Chat chat, String message) {

        return chat.sendMessage(message);
    }

    default Message sendMessage(Chat chat, SendableMessage sendableMessage) {

        return chat.sendMessage(sendableMessage);
    }

    default Map<Chat, Message> sendMessage(Collection<Chat> chats, String message) {

        return this.sendMessage(chats, SendableTextMessage.builder().message(message).build());
    }

    default Map<Chat, Message> sendMessage(Collection<Chat> chats, SendableMessage sendableMessage) {

        Map<Chat, Message> responses = new HashMap<>();

        for(Chat chat : chats) {

            responses.put(chat, chat.sendMessage(sendableMessage));
        }

        return responses;
    }

    default BotServer getServer() {

        return TelegramBotAPI.getBotServer();
    }

    @NonNull
    String getKey();
}