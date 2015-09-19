package pro.zackpollard.telegrambot.api.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.type.Voice;

/**
 * @author Zack Pollard
 */
public interface VoiceContent extends Content {

	Voice getContent();

	@Override
	default ContentType getType() {
		return ContentType.VOICE;
	}
}
