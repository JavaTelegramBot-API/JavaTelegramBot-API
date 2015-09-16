package org.telegram.botapi.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Audio extends DurationableFile, Mimetypeable {

	String getPerformer();

	String getTitle();
}