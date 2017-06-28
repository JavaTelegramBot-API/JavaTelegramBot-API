package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.NewChatParticipantContent;
import pro.zackpollard.telegrambot.api.chat.message.content.NewChatParticipantsContent;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zack Pollard
 */
public class NewChatParticipantsContentImpl implements NewChatParticipantsContent {

    private final Set<User> content;

    private NewChatParticipantsContentImpl(JSONArray jsonArray) {

        this.content = new HashSet<>();
        for(int i = 0; i < jsonArray.length(); ++i) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            content.add(UserImpl.createUser(jsonObject));
        }
    }

    public static NewChatParticipantsContent createNewParticipantsContent(JSONArray jsonArray) {

        return jsonArray != null ? new NewChatParticipantsContentImpl(jsonArray) : null;
    }

    /**
     * Gets the new participants in the chat
     *
     * @return A Set of the new participants, an empty set if there was no new participant (this shouldn't happen)
     */
    @Override
    public Set<User> getContent() {
        return content;
    }
}
