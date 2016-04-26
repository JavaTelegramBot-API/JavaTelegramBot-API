package pro.zackpollard.telegrambot.api.internal.chat.message.content.type;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.MessageEntity;
import pro.zackpollard.telegrambot.api.chat.message.content.type.MessageEntityType;

/**
 * @author Zack Pollard
 */
public class MessageEntityImpl implements MessageEntity {

    private final MessageEntityType type;
    private final int offset;
    private final int length;
    private final String url;

    private MessageEntityImpl(JSONObject jsonObject) {

        this.type = MessageEntityType.getType(jsonObject.getString("type"));
        this.offset = jsonObject.getInt("offset");
        this.length = jsonObject.getInt("length");
        this.url = jsonObject.optString("url");
    }

    public static MessageEntity createMessageEntity(JSONObject jsonObject) {

        return jsonObject != null ? new MessageEntityImpl(jsonObject) : null;
    }


    @Override
    public MessageEntityType getType() {
        return type;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public String getUrl() {
        return url;
    }
}
