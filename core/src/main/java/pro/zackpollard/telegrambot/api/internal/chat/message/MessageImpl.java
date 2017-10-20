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
    private final long date;
    private final Chat chat;
    private final User forward_from;
    private final Chat forward_from_chat;
    private final Integer forward_from_message_id;
    private final String forward_signature;
    private final Long forward_date;
    private final Message reply_to_message;
    private final Long edit_date;
    private final String author_signature;
    private final Content content;

    private final TelegramBot telegramBot;

    private MessageImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        if (!jsonObject.isNull("result")) jsonObject = jsonObject.getJSONObject("result");

        jsonMessage = jsonObject;

        message_id = jsonObject.getInt("message_id");
        from = UserImpl.createUser(jsonObject.optJSONObject("from"));
        date = jsonObject.getLong("date");
        chat = ChatImpl.createChat(jsonObject.getJSONObject("chat"), telegramBot);
        forward_from = UserImpl.createUser(jsonObject.optJSONObject("forward_from"));
        forward_from_chat = ChatImpl.createChat(jsonObject.optJSONObject("forward_from_chat"), telegramBot);
        forward_from_message_id = jsonObject.optInt("forward_from_message_id");
        forward_signature = jsonObject.optString("forward_signature");
        forward_date = jsonObject.optLong("forward_date");
        reply_to_message = MessageImpl.createMessage(jsonObject.optJSONObject("reply_to_message"), telegramBot);
        edit_date = jsonObject.optLong("edit_date");
        author_signature = jsonObject.optString("author_signature");
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
    public long getMessageId() {
        return message_id;
    }

    /**
     * Get the UNIX timestamp of when this message was sent/received at
     *
     * @return The timestamp
     */
    @Override
    public long getTimeStamp() {
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
     * Gets the chat the message was forwarded from
     *
     * @return The channel from which the message was forwarded, or null if the message wasn't forwarded or wasn't from a channel
     */
    @Override
    public Chat getChatForwardedFrom() {
        return forward_from_chat;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getForwardFromMessageId() {
        return forward_from_message_id;
    }

    @Override
    public String getForwardSignature() {
        return forward_signature;
    }

    /**
     * Gets the UNIX timestamp of when the original forwarded message was sent
     *
     * @return The forwarded messages timestamp, or 0 if the message wasn't forwarded
     */
    @Override
    public Long getForwardedDate() {
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
     * Gets the UNIX timestamp of when the message was edited
     *
     * @return The time that this message was edited, or null if it wasn't edited
     */
    @Override
    public Long getEditDate() {
        return edit_date;
    }

    @Override
    public String getAuthorSignature() {
        return author_signature;
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

    @Override
    public TelegramBot getBotInstance() {
        return telegramBot;
    }
}
