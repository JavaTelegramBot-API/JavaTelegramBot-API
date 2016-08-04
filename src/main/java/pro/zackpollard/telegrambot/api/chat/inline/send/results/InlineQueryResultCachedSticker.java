package pro.zackpollard.telegrambot.api.chat.inline.send.results;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.InlineReplyMarkup;
import pro.zackpollard.telegrambot.api.chat.inline.send.content.InputMessageContent;

/**
 * @author zackp
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineQueryResultCachedSticker implements InlineQueryResultCached {

    private final InlineQueryResultType type = InlineQueryResultType.STICKER;
    @NonNull
    private final String id;
    @NonNull
    private final String sticker_file_id;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultCachedStickerBuilder object used to construct the InlineQueryResultCachedSticker object
     */
    public static InlineQueryResultCachedStickerBuilder builder() {
        return new InlineQueryResultCachedStickerBuilder();
    }

    /**
     * Get the type of InlineQueryResult that this object refers to
     *
     * @return The InlineQueryResultType for this object
     */
    @Override
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
     * Gets the ID for the cached sticker file on the telegram servers
     *
     * @return The ID for the cached sticker file on the telegram servers
     */
    @NonNull
    public String getStickerFileId() {
        return this.sticker_file_id;
    }

    /**
     * Gets the inline keyboard attached to this message
     *
     * @return The inline keyboard attached to this message
     */
    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
    }

    /**
     * Gets the content of the message to be sent instead of the sticker
     *
     * @return The content of the message to be sent instead of the sticker
     */
    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    @ToString
    public static class InlineQueryResultCachedStickerBuilder {
        private String id;
        private String sticker_file_id;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultCachedStickerBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultCachedSticker.InlineQueryResultCachedStickerBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the ID of the cached sticker file on the telegram servers that you want this result to use
         *
         * @param stickerFileId The ID of the cached sticker file you want to use from the telegram servers
         *
         * @return The builder object
         */
        public InlineQueryResultCachedSticker.InlineQueryResultCachedStickerBuilder stickerFileId(String stickerFileId) {
            this.sticker_file_id = stickerFileId;
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
        public InlineQueryResultCachedSticker.InlineQueryResultCachedStickerBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        /**
         * *Optional*
         * Sets the content you want to be sent with this result to the provided InputMessageContent object
         *
         * @param inputMessageContent The content you want to be sent with the result
         *
         * @return The builder object
         */
        public InlineQueryResultCachedSticker.InlineQueryResultCachedStickerBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * Builds the InlineQueryResultCachedSticker object
         *
         * @return An InlineQueryResultCachedSticker object based on the previously provided values
         */
        public InlineQueryResultCachedSticker build() {
            return new InlineQueryResultCachedSticker(id, sticker_file_id, reply_markup, input_message_content);
        }
    }
}
