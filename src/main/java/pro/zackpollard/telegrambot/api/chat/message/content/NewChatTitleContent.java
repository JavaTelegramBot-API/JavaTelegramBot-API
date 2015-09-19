package pro.zackpollard.telegrambot.api.chat.message.content;

/**
 * @author Zack Pollard
 */
public interface NewChatTitleContent extends Content {

	/**
	 * Gets the new chat title
	 *
	 * @return The new chat title
	 */
	String getContent();

	@Override
	default ContentType getType() {

		return ContentType.NEW_CHAT_TITLE;
	}
}
