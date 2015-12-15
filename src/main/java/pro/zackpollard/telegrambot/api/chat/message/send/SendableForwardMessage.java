package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.Message;

/**
 * @author Zack Pollard
 */

@RequiredArgsConstructor
public class SendableForwardMessage implements SendableMessage {

	@NonNull
	@Getter
	private final Integer forwardedMessage;

    SendableForwardMessage(int forwardedMessage) {

        this.forwardedMessage = forwardedMessage;
    }

    SendableForwardMessage(Message forwardedMessage) {

        this(forwardedMessage != null ? forwardedMessage.getMessageId() : null);
    }

    public static SendableForwardMessageBuilder builder() {
        return new SendableForwardMessageBuilder();
    }

    @Override
	public MessageType getType() {
		return MessageType.FORWARDED;
	}

    public static class SendableForwardMessageBuilder {

        private int forwardedMessage;

        SendableForwardMessageBuilder() {
        }

        public SendableForwardMessage.SendableForwardMessageBuilder forwardedMessage(Message forwardedMessage) {
            this.forwardedMessage = forwardedMessage != null ? forwardedMessage.getMessageId() : null;
            return this;
        }

        public SendableForwardMessage.SendableForwardMessageBuilder forwardedMessage(Integer forwardedMessage) {
            this.forwardedMessage = forwardedMessage;
            return this;
        }

        public SendableForwardMessage build() {
            return new SendableForwardMessage(forwardedMessage);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableForwardMessage.SendableForwardMessageBuilder(forwardedMessage=" + this.forwardedMessage + ")";
        }
    }
}