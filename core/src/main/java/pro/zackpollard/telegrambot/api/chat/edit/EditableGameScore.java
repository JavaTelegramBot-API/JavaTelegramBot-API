package pro.zackpollard.telegrambot.api.chat.edit;

import lombok.*;
import pro.zackpollard.telegrambot.api.chat.ChatType;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableAudioMessage;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class EditableGameScore implements EditableMessage {

    @NonNull
    @Getter
    private final long userId;
    @NonNull
    @Getter
    private final long score;
    @Getter
    private final long chatId;
    @Getter
    private final long messageId;
    @Getter
    private final String inlineMessageId;
    @Getter
    private final boolean editMessage;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A EditableGameScoreBuilder object used to construct the EditableGameScore object
     */
    public static EditableGameScoreBuilder builder() {
        return new EditableGameScoreBuilder();
    }

    /**
     * Gets the EditType of this EditableMessage object
     *
     * @return The EditType of this object
     */
    @Override
    public EditType getType() {
        return EditType.GAME;
    }

    public static class EditableGameScoreBuilder {
        private long userId;
        private long score;
        private long chatId;
        private long messageId;
        private String inlineMessageId;
        private boolean editMessage;

        EditableGameScoreBuilder() {
        }

        public EditableGameScore.EditableGameScoreBuilder userId(long userId) {
            this.userId = userId;
            return this;
        }

        public EditableGameScore.EditableGameScoreBuilder score(long score) {
            this.score = score;
            return this;
        }

        public EditableGameScore.EditableGameScoreBuilder message(Message message) {
            switch(message.getChat().getType()) {
                case GROUP:
                case SUPERGROUP:
                case PRIVATE: {
                    this.message(Long.valueOf(message.getChat().getId()), message.getMessageId());
                    break;
                }
                default:
                    System.err.println("EditableGameScoreBuilder#message(Message) was called using a message from a channel. This is not supported by the API.");
            }
            return this;
        }

        public EditableGameScore.EditableGameScoreBuilder message(long chatId, long messageId) {
            this.chatId = chatId;
            this.messageId = messageId;
            this.inlineMessageId = null;
            return this;
        }

        public EditableGameScore.EditableGameScoreBuilder inlineMessageId(String inlineMessageId) {
            this.inlineMessageId = inlineMessageId;
            return this;
        }

        public EditableGameScore.EditableGameScoreBuilder editMessage(boolean editMessage) {
            this.editMessage = editMessage;
            return this;
        }

        public EditableGameScore build() {
            return new EditableGameScore(userId, score, chatId, messageId, inlineMessageId, editMessage);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.edit.EditableGameScore.EditableGameScoreBuilder(userId=" + this.userId + ", score=" + this.score + ", chatId=" + this.chatId + ", messageId=" + this.messageId + ", inlineMessageId=" + this.inlineMessageId + ", editMessage=" + this.editMessage + ")";
        }
    }
}