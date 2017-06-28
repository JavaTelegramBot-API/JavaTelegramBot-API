package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.VideoContent;
import pro.zackpollard.telegrambot.api.chat.message.content.VideoNoteContent;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Video;
import pro.zackpollard.telegrambot.api.chat.message.content.type.VideoNote;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.VideoImpl;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.VideoNoteImpl;

/**
 * @author Zack Pollard
 */
public class VideoNoteContentImpl implements VideoNoteContent {

    private final VideoNote content;

    private VideoNoteContentImpl(JSONObject jsonObject) {

        this.content = VideoNoteImpl.createVideoNote(jsonObject);
    }

    public static VideoNoteContent createVideoNoteContent(JSONObject jsonObject) {

        return jsonObject != null ? new VideoNoteContentImpl(jsonObject) : null;
    }

    @Override
    public VideoNote getContent() {

        return content;
    }
}
