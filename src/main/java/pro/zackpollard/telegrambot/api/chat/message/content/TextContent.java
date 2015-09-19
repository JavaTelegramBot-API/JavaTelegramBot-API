package pro.zackpollard.telegrambot.api.chat.message.content;

/**
 * @author Zack Pollard
 */
public interface TextContent extends Content {

	String getContent();

	@Override
	default ContentType getType() {

		return ContentType.TEXT;
	}
}
