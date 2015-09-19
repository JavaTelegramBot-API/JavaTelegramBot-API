package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.VoiceContent;

/**
 * @author Zack Pollard
 */
public class VoiceMessageReceivedEvent extends MessageReceivedEvent {

	public VoiceMessageReceivedEvent(Message message) {

		super(message);
	}

	@Override
	public VoiceContent getContent() {

		return (VoiceContent) getMessage().getContent();
	}
}