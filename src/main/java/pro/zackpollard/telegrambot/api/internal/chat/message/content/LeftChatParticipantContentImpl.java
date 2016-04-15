package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.LeftChatParticipantContent;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public class LeftChatParticipantContentImpl implements LeftChatParticipantContent {

    private final User content;

    private LeftChatParticipantContentImpl(JSONObject jsonObject) {

        this.content = UserImpl.createUser(jsonObject);
    }

    public static LeftChatParticipantContent createLeftChatParticipantContent(JSONObject jsonObject) {

        return jsonObject != null ? new LeftChatParticipantContentImpl(jsonObject) : null;
    }

    /**
     * Gets the participant who left the chat
     *
     * @return The previous participant, or null if there was no participant
     */
    @Override
    public User getContent() {
        return content;
    }
}
