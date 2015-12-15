package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */

@RequiredArgsConstructor
public class SendableDocumentMessage implements SendableMessage, ReplyingOptions {

	@NonNull
	@Getter
	private final InputFile document;
	@Getter
	private final int replyTo;
	@Getter
	private final ReplyMarkup replyMarkup;

    public SendableDocumentMessage(InputFile document, Message replyTo, ReplyMarkup replyMarkup) {

        this(document, replyTo != null ? replyTo.getMessageId() : 0, replyMarkup);
    }

    public static SendableDocumentMessageBuilder builder() {
        return new SendableDocumentMessageBuilder();
    }

    @Override
	public MessageType getType() {
		return MessageType.DOCUMENT;
	}

    public static class SendableDocumentMessageBuilder {

        private InputFile document;
        private int replyTo;
        private ReplyMarkup replyMarkup;

        SendableDocumentMessageBuilder() {
        }

        public SendableDocumentMessage.SendableDocumentMessageBuilder document(InputFile document) {
            this.document = document;
            return this;
        }

        public SendableDocumentMessage.SendableDocumentMessageBuilder replyTo(Message replyTo) {
            this.replyTo = replyTo != null ? replyTo.getMessageId() : 0;
            return this;
        }

        public SendableDocumentMessage.SendableDocumentMessageBuilder replyTo(int replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public SendableDocumentMessage.SendableDocumentMessageBuilder replyMarkup(ReplyMarkup replyMarkup) {
            this.replyMarkup = replyMarkup;
            return this;
        }

        public SendableDocumentMessage build() {
            return new SendableDocumentMessage(document, replyTo, replyMarkup);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.message.send.SendableDocumentMessage.SendableDocumentMessageBuilder(document=" + this.document + ", replyTo=" + this.replyTo + ", replyMarkup=" + this.replyMarkup + ")";
        }
    }
}