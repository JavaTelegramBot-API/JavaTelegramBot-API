package pro.zackpollard.telegrambot.api.chat.inline.send.results;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.InlineReplyMarkup;
import pro.zackpollard.telegrambot.api.utils.Utils;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineQueryResultGame implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.GAME;
    @NonNull
    private final String id;
    @NonNull
    private final String game_short_name;
    private final InlineReplyMarkup reply_markup;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultGameBuilder object used to construct the InlineQueryResultArticle object
     */
    public static InlineQueryResultGameBuilder builder() {
        return new InlineQueryResultGameBuilder();
    }

    /**
     * Get the type of InlineQueryResult that this object refers to
     *
     * @return The InlineQueryResultType for this object
     */
    public InlineQueryResultType getType() {
        return this.type;
    }

    /**
     * Gets the ID of this InlineQueryResult object
     *
     * @return The ID of this result
     */
    @NonNull
    public String getId() {
        return this.id;
    }

    /**
     * Gets the inline keyboard attached to this message
     *
     * @return The inline keyboard attached to this message
     */
    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
    }

    @ToString
    public static class InlineQueryResultGameBuilder {

        private String id = Utils.generateRandomString(32);
        private String game_short_name;
        private InlineReplyMarkup reply_markup;

        InlineQueryResultGameBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultGame.InlineQueryResultGameBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the title to the provided value
         *
         * @param gameShortName The title you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultGame.InlineQueryResultGameBuilder gameShortName(String gameShortName) {
            this.game_short_name = gameShortName;
            return this;
        }

        /**
         * *Optional*
         * Sets the inline keyboard attached to this message to the InlineReplyMarkup provided
         *
         * @param replyMarkup The inline keyboard you want to attach to the message
         *
         * @return The builder object
         */
        public InlineQueryResultGame.InlineQueryResultGameBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        /**
         * Builds the InlineQueryResultGame object
         *
         * @return An InlineQueryResultGame object based on the previously provided values
         */
        public InlineQueryResultGame build() {
            return new InlineQueryResultGame(id, game_short_name, reply_markup);
        }
    }
}
