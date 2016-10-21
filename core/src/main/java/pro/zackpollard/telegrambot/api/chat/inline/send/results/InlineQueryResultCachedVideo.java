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
public class InlineQueryResultCachedVideo implements InlineQueryResultCached {

    private final InlineQueryResultType type = InlineQueryResultType.VIDEO;
    @NonNull
    private final String id;
    @NonNull
    private final String video_file_id;
    @NonNull
    private final String title;
    private final String caption;
    private final String description;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultCachedVideoBuilder object used to construct the InlineQueryResultCachedVideo object
     */
    public static InlineQueryResultCachedVideoBuilder builder() {
        return new InlineQueryResultCachedVideoBuilder();
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
     * Gets the ID for the cached video file on the telegram servers
     *
     * @return The ID for the cached video file on the telegram servers
     */
    @NonNull
    public String getVideoFileId() {
        return this.video_file_id;
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
     * Gets the description of the result
     *
     * @return The description of the result
     */
    public String getDescription() {
        return this.description;
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
     * Gets the content of the message to be sent instead of the video
     *
     * @return The content of the message to be sent instead of the video
     */
    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    @ToString
    public static class InlineQueryResultCachedVideoBuilder {
        private String id = Utils.generateRandomString(32);
        private String video_file_id;
        private String title;
        private String caption;
        private String description;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultCachedVideoBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultCachedVideoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the ID of the cached video file on the telegram servers that you want this result to use
         *
         * @param videoFileId The ID of the cached video file you want to use from the telegram servers
         *
         * @return The builder object
         */
        public InlineQueryResultCachedVideoBuilder videoFileId(String videoFileId) {
            this.video_file_id = videoFileId;
            return this;
        }

        /**
         * *Required*
         * Sets the title to the provided value
         *
         * @param title The title you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultCachedVideoBuilder title(String title) {
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
        public InlineQueryResultCachedVideoBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        /**
         * *Optional*
         * Sets the description to the provided value
         *
         * @param description The description you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultCachedVideoBuilder description(String description) {
            this.description = description;
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
        public InlineQueryResultCachedVideoBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
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
        public InlineQueryResultCachedVideoBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * Builds the InlineQueryResultCachedVideo object
         *
         * @return An InlineQueryResultCachedVideo object based on the previously provided values
         */
        public InlineQueryResultCachedVideo build() {
            return new InlineQueryResultCachedVideo(id, video_file_id, title, caption, description, reply_markup, input_message_content);
        }
    }
}
