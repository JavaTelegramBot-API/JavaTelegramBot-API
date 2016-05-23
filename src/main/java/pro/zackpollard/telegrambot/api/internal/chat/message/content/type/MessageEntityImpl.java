package pro.zackpollard.telegrambot.api.internal.chat.message.content.type;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.MessageEntity;
import pro.zackpollard.telegrambot.api.chat.message.content.type.MessageEntityType;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public class MessageEntityImpl implements MessageEntity {

    private final MessageEntityType type;
    private final int offset;
    private final int length;
    private final String url;
    private final User user;

    private MessageEntityImpl(JSONObject jsonObject) {

        this.type = MessageEntityType.getType(jsonObject.getString("type"));
        this.offset = jsonObject.getInt("offset");
        this.length = jsonObject.getInt("length");
        this.url = jsonObject.optString("url");
        this.user = UserImpl.createUser(jsonObject.optJSONObject("user"));
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

    @Override
    public User getUser() {
        return user;
    }
}
