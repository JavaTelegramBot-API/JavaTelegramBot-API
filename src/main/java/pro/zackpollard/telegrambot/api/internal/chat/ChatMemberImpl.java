package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.ChatMember;
import pro.zackpollard.telegrambot.api.chat.ChatMemberStatus;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public class ChatMemberImpl implements ChatMember {

    private final User user;
    private final ChatMemberStatus status;

    private ChatMemberImpl(JSONObject jsonObject) {

        this.user = UserImpl.createUser(jsonObject.getJSONObject("user"));
        this.status = ChatMemberStatus.valueOf(jsonObject.getString("status"));
    }

    public static ChatMember createChatMember(JSONObject jsonObject) {

        return new ChatMemberImpl(jsonObject);
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public ChatMemberStatus getStatus() {
        return status;
    }
}
