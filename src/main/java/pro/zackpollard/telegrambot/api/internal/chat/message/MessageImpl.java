package pro.zackpollard.telegrambot.api.internal.chat.message;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.Content;
import pro.zackpollard.telegrambot.api.internal.chat.ChatImpl;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.ContentImpl;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public class MessageImpl implements Message {

    private final JSONObject jsonMessage;

    private final int message_id;
    private final User from;
    private final int date;
    private final Chat chat;
    private final User forward_from;
    private final int forward_date;
    private final Message reply_to_message;
    private final Content content;

    private final TelegramBot telegramBot;

    private MessageImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        if (!jsonObject.isNull("result")) jsonObject = jsonObject.getJSONObject("result");

        jsonMessage = jsonObject;

        message_id = jsonObject.getInt("message_id");
        from = UserImpl.createUser(jsonObject.optJSONObject("from"));
        date = jsonObject.getInt("date");
        chat = ChatImpl.createChat(jsonObject.getJSONObject("chat"), telegramBot);
        forward_from = UserImpl.createUser(jsonObject.optJSONObject("forward_from"));
        forward_date = jsonObject.optInt("forward_date");
        reply_to_message = MessageImpl.createMessage(jsonObject.optJSONObject("reply_to_message"), telegramBot);
        content = ContentImpl.createContent(jsonObject, telegramBot);

        this.telegramBot = telegramBot;
    }

    public static Message createMessage(JSONObject jsonObject, TelegramBot telegramBot) {

        return jsonObject != null ? new MessageImpl(jsonObject, telegramBot) : null;
    }

    /**
     * Get the ID of the message
     *
     * @return The ID of the message
     */
    @Override
    public int getMessageId() {
        return message_id;
    }

    /**
     * Get the UNIX timestamp of when this message was sent/received at
     *
     * @return The timestamp
     */
    @Override
    public int getTimeStamp() {
        return date;
    }

    /**
     * Get the user that sent the message
     *
     * @return The user
     */
    @Override
    public User getSender() {
        return from;
    }

    /**
     * Get the chat this message was sent in
     *
     * @return The chat
     */
    @Override
    public Chat getChat() {
        return chat;
    }

    /**
     * Gets the user the message was forwarded from
     *
     * @return The user who's message was forwarded, or null if the message wasn't forwarded
     */
    @Override
    public User getForwardedFrom() {
        return forward_from;
    }

    /**
     * Gets the UNIX timestamp of when the original forwarded message was sent
     *
     * @return The forwarded messages timestamp, or 0 if the message wasn't forwarded
     */
    @Override
    public int getForwardedDate() {
        return forward_date;
    }

    /**
     * Gets the message that this message replied to
     *
     * @return The message that was replied to, or null if this message wasn't a reply
     */
    @Override
    public Message getRepliedTo() {
        return reply_to_message;
    }

    /**
     * Gets the content of the message
     *
     * @return The content of the message
     */
    @Override
    public Content getContent() {
        return content;
    }

    /**
     * Gets the JSON object provided by the Telegram API
     *
     * @return The JSON provided by the Telegram API
     */
    @Override
    public JSONObject asJson() {
        return jsonMessage;
    }
}
