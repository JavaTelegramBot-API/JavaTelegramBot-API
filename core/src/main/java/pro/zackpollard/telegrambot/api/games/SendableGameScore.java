package pro.zackpollard.telegrambot.api.games;

import lombok.*;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SendableGameScore {

    @NonNull
    @Getter
    private final Integer userId;
    @NonNull
    @Getter
    private final Long score;
    @Getter
    private final boolean force;
    @Getter
    private final boolean disableEditMessage;
    @Getter
    private final Long chatId;
    @Getter
    private final Integer messageId;
    @Getter
    private final String inlineMessageId;

    public static SendableGameScoreBuilder builder() {
        return new SendableGameScoreBuilder();
    }

    @ToString
    public static class SendableGameScoreBuilder {
        private Integer userId;
        private Long score;
        private boolean force;
        private boolean disableEditMessage;
        private Long chatId;
        private Integer messageId;
        private String inlineMessageId;

        SendableGameScoreBuilder() {
        }

        public SendableGameScore.SendableGameScoreBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public SendableGameScore.SendableGameScoreBuilder score(Long score) {
            this.score = score;
            return this;
        }

        public SendableGameScore.SendableGameScoreBuilder force(boolean force) {
            this.force = force;
            return this;
        }

        public SendableGameScore.SendableGameScoreBuilder disableEditMessage(boolean disableEditMessage) {
            this.disableEditMessage = disableEditMessage;
            return this;
        }

        public SendableGameScore.SendableGameScoreBuilder chatId(Long chatId, Integer messageId) {
            this.chatId = chatId;
            this.messageId = messageId;
            this.inlineMessageId = null;
            return this;
        }

        public SendableGameScore.SendableGameScoreBuilder inlineMessageId(String inlineMessageId) {
            this.inlineMessageId = inlineMessageId;
            this.chatId = null;
            this.messageId = null;
            return this;
        }

        public SendableGameScore build() {
            return new SendableGameScore(userId, score, force, disableEditMessage, chatId, messageId, inlineMessageId);
        }
    }
}