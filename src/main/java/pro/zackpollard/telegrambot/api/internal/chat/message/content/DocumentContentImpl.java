package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.DocumentContent;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Document;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.DocumentImpl;

/**
 * @author Zack Pollard
 */
public class DocumentContentImpl implements DocumentContent {

    private final Document content;
    private final String caption;

    private DocumentContentImpl(JSONObject jsonObject, String caption) {

        this.content = DocumentImpl.createDocument(jsonObject);
        this.caption = caption;
    }

    public static DocumentContent createDocumentContent(JSONObject jsonObject, String caption) {

        return jsonObject != null ? new DocumentContentImpl(jsonObject, caption) : null;
    }

    @Override
    public Document getContent() {
        return content;
    }
}
