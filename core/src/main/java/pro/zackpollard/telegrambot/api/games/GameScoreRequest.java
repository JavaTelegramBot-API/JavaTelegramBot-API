package pro.zackpollard.telegrambot.api.games;

import lombok.*;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GameScoreRequest {

    @NonNull
    @Getter
    private final Integer userId;
    @Getter
    private final Long chatId;
    @Getter
    private final Integer messageId;
    @Getter
    private final String inlineMessageId;

    public static GameScoreRequestBuilder builder() {
        return new GameScoreRequestBuilder();
    }

    @ToString
    public static class GameScoreRequestBuilder {
        private Integer userId;
        private Long chatId;
        private Integer messageId;
        private String inlineMessageId;

        GameScoreRequestBuilder() {
        }

        public GameScoreRequest.GameScoreRequestBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public GameScoreRequest.GameScoreRequestBuilder message(Long chatId, Integer messageId) {
            this.chatId = chatId;
            this.messageId = messageId;
            this.inlineMessageId = null;
            return this;
        }

        public GameScoreRequest.GameScoreRequestBuilder inlineMessageId(String inlineMessageId) {
            this.inlineMessageId = inlineMessageId;
            this.chatId = null;
            this.messageId = null;
            return this;
        }

        public GameScoreRequest build() {
            return new GameScoreRequest(userId, chatId, messageId, inlineMessageId);
        }
    }
}