package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.VoiceContent;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Voice;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.VoiceImpl;

/**
 * @author Zack Pollard
 */
public class VoiceContentImpl implements VoiceContent {

    private final Voice content;

    private VoiceContentImpl(JSONObject jsonObject) {

        this.content = VoiceImpl.createVoice(jsonObject);
    }

    public static VoiceContent createVoiceContent(JSONObject jsonObject) {

        return jsonObject != null ? new VoiceContentImpl(jsonObject) : null;
    }

    @Override
    public Voice getContent() {
        return content;
    }
}
