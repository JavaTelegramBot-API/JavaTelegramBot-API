package pro.zackpollard.telegrambot.api.chat.inline.send.results;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.InlineReplyMarkup;
import pro.zackpollard.telegrambot.api.chat.inline.send.content.InputMessageContent;
import pro.zackpollard.telegrambot.api.utils.Utils;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineQueryResultCachedMpeg4Gif implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.MPEG4_GIF;
    @NonNull
    private final String id;
    @NonNull
    private final String mpeg4_file_id;
    private final String title;
    private final String caption;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultCachedMpeg4GifBuilder object used to construct the InlineQueryResultCachedMpeg4Gif object
     */
    public static InlineQueryResultCachedMpeg4GifBuilder builder() {
        return new InlineQueryResultCachedMpeg4GifBuilder();
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
     * Gets the ID for the cached mpeg4gif file on the telegram servers
     *
     * @return The ID for the cached mpeg4gif file on the telegram servers
     */
    @NonNull
    public String getMpeg4FileId() {
        return this.mpeg4_file_id;
    }

    /**
     * Gets the title of the result
     *
     * @return The title of the result
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the caption for the result
     *
     * @return The caption for the result
     */
    public String getCaption() {
        return this.caption;
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
     * Gets the content of the message to be sent instead of the video animation
     *
     * @return The content of the message to be sent instead of the video animation
     */
    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    @ToString
    public static class InlineQueryResultCachedMpeg4GifBuilder {
        private String id = Utils.generateRandomString(32);
        private String mpeg4_file_id;
        private String title;
        private String caption;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultCachedMpeg4GifBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultCachedMpeg4GifBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the ID of the cached mpeg4gif file on the telegram servers that you want this result to use
         *
         * @param mpeg4FileId The ID of the cached mpeg4gif file you want to use from the telegram servers
         *
         * @return The builder object
         */
        public InlineQueryResultCachedMpeg4GifBuilder mpeg4FileId(String mpeg4FileId) {
            this.mpeg4_file_id = mpeg4FileId;
            return this;
        }

        /**
         * *Optional*
         * Sets the title to the provided value
         *
         * @param title The title you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultCachedMpeg4GifBuilder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * *Optional*
         * Sets the caption to the provided value. This can be 0-200 characters in length
         *
         * @param caption The caption you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultCachedMpeg4GifBuilder caption(String caption) {
            this.caption = caption;
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
        public InlineQueryResultCachedMpeg4GifBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
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
        public InlineQueryResultCachedMpeg4GifBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * Builds the InlineQueryResultCachedMpeg4Gif object
         *
         * @return An InlineQueryResultCachedMpeg4Gif object based on the previously provided values
         */
        public InlineQueryResultCachedMpeg4Gif build() {
            return new InlineQueryResultCachedMpeg4Gif(id, mpeg4_file_id, title, caption, reply_markup, input_message_content);
        }
    }
}
