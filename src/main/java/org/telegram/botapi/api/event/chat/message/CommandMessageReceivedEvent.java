package org.telegram.botapi.api.event.chat.message;

import lombok.Getter;
import org.telegram.botapi.api.chat.message.Message;

/**
 * @author Zack Pollard
 */
public class CommandMessageReceivedEvent extends TextMessageReceivedEvent {

	@Getter
	private final String[] args;
	@Getter
	private final String argsString;
	@Getter
	private final String command;

	public CommandMessageReceivedEvent(Message message) {

		super(message);

		this.command = getContent().getContent().substring(1).split(" ")[0].split("@")[0];

		int argsStart = getContent().getContent().indexOf(" ");

		if(argsStart != -1) {

			this.argsString = getContent().getContent().substring(argsStart).trim();
			this.args = argsString.split(" ");
		} else {

			this.args = new String[]{};
			this.argsString = "";
		}
	}
}