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
	private final Integer messageID;
    @NonNull
    @Getter
    private final String chatID;

    SendableForwardMessage(Message forwardedMessage) {

        this(forwardedMessage != null ? forwardedMessage.getMessageId() : null, forwardedMessage != null ? forwardedMessage.getChat().getId() : null);
    }

    public static SendableForwardMessageBuilder builder() {
        return new SendableForwardMessageBuilder();
    }

    @Override
	public MessageType getType() {
		return MessageType.FORWARDED;
	}

    public static class SendableForwardMessageBuilder {

        private Integer messageID;
        private String chatID;

        SendableForwardMessageBuilder() {
        }

        public SendableForwardMessage.SendableForwardMessageBuilder forwardedMessage(Message forwardedMessage) {
            this.messageID = forwardedMessage != null ? forwardedMessage.getMessageId() : null;
            this.chatID = forwardedMessage != null ? forwardedMessage.getChat().getId() : null;
            return this;
        }

        public SendableForwardMessage.SendableForwardMessageBuilder messageID(Integer messageID) {
            this.messageID = messageID;
            return this;
        }

        public SendableForwardMessage.SendableForwardMessageBuilder chatID(String chatID) {
            this.chatID = chatID;
            return this;
        }

        public SendableForwardMessage build() {
            return new SendableForwardMessage(messageID, chatID);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableForwardMessage.SendableForwardMessageBuilder(messageID=" + this.messageID + ", chatID=" + this.chatID + ")";
        }
    }
}