package pro.zackpollard.telegrambot.api.chat.inline.send.results;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.InlineReplyMarkup;
import pro.zackpollard.telegrambot.api.chat.inline.send.content.InputMessageContent;
import pro.zackpollard.telegrambot.api.utils.Utils;

/**
 * @author zackp
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineQueryResultCachedDocument implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.DOCUMENT;
    @NonNull
    private final String id;
    @NonNull
    private final String title;
    private final String caption;
    @NonNull
    private final String document_file_id;
    private final String description;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultCachedDocumentBuilder object used to construct the InlineQueryResultCachedDocument object
     */
    public static InlineQueryResultCachedDocumentBuilder builder() {
        return new InlineQueryResultCachedDocumentBuilder();
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
     * Gets the ID for the cached document file on the telegram servers
     *
     * @return The ID for the cached document file on the telegram servers
     */
    @NonNull
    public String getDocumentFileId() {
        return this.document_file_id;
    }

    /**
     * Gets the title of the result
     *
     * @return The title of the result
     */
    @NonNull
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
     * Gets the content of the message to be sent instead of the document
     *
     * @return The content of the message to be sent instead of the document
     */
    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    @ToString
    public static class InlineQueryResultCachedDocumentBuilder {
        private String id = Utils.generateRandomString(32);
        private String title;
        private String caption;
        private String document_file_id;
        private String description;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultCachedDocumentBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultCachedDocumentBuilder id(String id) {
            this.id = id;
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
        public InlineQueryResultCachedDocumentBuilder title(String title) {
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
        public InlineQueryResultCachedDocumentBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        /**
         * *Required*
         * Sets the ID of the cached document file on the telegram servers that you want this result to use
         *
         * @param documentFileId The ID of the cached document file you want to use from the telegram servers
         *
         * @return The builder object
         */
        public InlineQueryResultCachedDocumentBuilder documentFileId(String documentFileId) {
            this.document_file_id = documentFileId;
            return this;
        }

        /**
         * *Optional*
         * Sets the descrption to the provided value
         *
         * @param description The descrption for the result
         *
         * @return The builder object
         */
        public InlineQueryResultCachedDocumentBuilder description(String description) {
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
        public InlineQueryResultCachedDocumentBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
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
        public InlineQueryResultCachedDocumentBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * Builds the InlineQueryResultCachedDocument object
         *
         * @return An InlineQueryResultCachedDocument object based on the previously provided values
         */
        public InlineQueryResultCachedDocument build() {
            return new InlineQueryResultCachedDocument(id, title, caption, document_file_id, description, reply_markup, input_message_content);
        }
    }
}