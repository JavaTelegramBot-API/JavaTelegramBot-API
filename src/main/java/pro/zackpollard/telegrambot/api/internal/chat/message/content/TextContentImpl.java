package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import org.json.JSONArray;
import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.chat.message.content.type.MessageEntity;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.MessageEntityImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class TextContentImpl implements TextContent {

	private final String content;
	private final List<MessageEntity> entities;

	private TextContentImpl(String text, JSONArray entities) {

		this.entities = new LinkedList<>();

		this.content = text;
		for(int i = 0; i < entities.length(); ++i) {

			MessageEntity messageEntity = MessageEntityImpl.createMessageEntity(entities.getJSONObject(i));

			if(messageEntity != null) {

				this.entities.add(messageEntity);
			}
		}
	}

	public static TextContent createTextContent(String text, JSONArray entities) {

		return text != null ? new TextContentImpl(text, entities) : null;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public List<MessageEntity> getEntities() {
		return entities;
	}
}
