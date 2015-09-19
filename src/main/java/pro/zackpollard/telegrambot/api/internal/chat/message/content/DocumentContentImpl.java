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

	private DocumentContentImpl(JSONObject jsonObject) {

		this.content = DocumentImpl.createDocument(jsonObject);
	}

	public static DocumentContent createDocumentContent(JSONObject jsonObject) {

		return jsonObject != null ? new DocumentContentImpl(jsonObject) : null;
	}

	@Override
	public Document getContent() {
		return content;
	}
}
