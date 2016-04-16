package pro.zackpollard.telegrambot.api.chat.message;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.content.Content;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableForwardMessage;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public interface Message {

    /**
     * Get the ID of the message
     *
     * @return The ID of the message
     */
    int getMessageId();

    /**
     * Get the UNIX timestamp of when this message was sent/received at
     *
     * @return The timestamp
     */
    int getTimeStamp();

    /**
     * Get the user that sent the message
     *
     * @return The user
     */
    User getSender();

    /**
     * Get the chat this message was sent in
     *
     * @return The chat
     */
    Chat getChat();

    /**
     * Gets the user the message was forwarded from
     *
     * @return The user who's message was forwarded, or null if the message wasn't forwarded
     */
    User getForwardedFrom();

    /**
     * Gets the UNIX timestamp of when the original forwarded message was sent
     *
     * @return The forwarded messages timestamp, or 0 if the message wasn't forwarded
     */
    int getForwardedDate();

    /**
     * Gets the message that this message replied to
     *
     * @return The message that was replied to, or null if this message wasn't a reply
     */
    Message getRepliedTo();

    /**
     * Gets the content of the message
     *
     * @return The content of the message
     */
    Content getContent();

    /**
     * Gets the JSON object provided by the Telegram API
     *
     * @return The JSON provided by the Telegram API
     */
    JSONObject asJson();

    default Message forwardMessage(Chat chat) {

        return chat.sendMessage(SendableForwardMessage.builder().forwardedMessage(this).build());
    }
}