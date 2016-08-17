package pro.zackpollard.telegrambot.api.chat.inline.send.results;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.InlineReplyMarkup;
import pro.zackpollard.telegrambot.api.chat.inline.send.content.InputMessageContent;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.net.URL;

/**
 * @author zackp
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineQueryResultDocument implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.DOCUMENT;
    @NonNull
    private final String id;
    @NonNull
    private final String title;
    private final String caption;
    @NonNull
    private final URL document_url;
    @NonNull
    private final String mime_type;
    private final String description;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;
    private final URL thumb_url;
    private final Integer thumb_width;
    private final Integer thumb_height;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultDocumentBuilder object used to construct the InlineQueryResultDocument object
     */
    public static InlineQueryResultDocumentBuilder builder() {
        return new InlineQueryResultDocumentBuilder();
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
     * Gets the URL of the document
     *
     * @return The URL of the document
     */
    @NonNull
    public URL getDocumentUrl() {
        return this.document_url;
    }

    /**
     * Gets the mime type of the document file. E.g. application/pdf or application/msword
     * @see <a href="http://www.freeformatter.com/mime-types-list.html">You can find a complete list of mimetypes here</a>
     *
     * @return The mime type of the document
     */
    @NonNull
    public String getMimeType() {
        return this.mime_type;
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

    /**
     * Gets the URL of the thumbnail for the result
     *
     * @return The URL of the thumbnail for the result
     */
    public URL getThumbUrl() {
        return this.thumb_url;
    }

    /**
     * Gets the width of the thumbnail in pixels
     *
     * @return The width of the thumbnail in pixels
     */
    public int getThumbWidth() {
        return this.thumb_width;
    }

    /**
     * Gets the height of the thumbnail in pixels
     *
     * @return The height of the thumbnail in pixels
     */
    public int getThumbHeight() {
        return this.thumb_height;
    }

    @ToString
    public static class InlineQueryResultDocumentBuilder {
        private String id = Utils.generateRandomString(32);
        private String title;
        private String caption;
        private URL document_url;
        private String mime_type;
        private String description;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;
        private URL thumb_url;
        private Integer thumb_width;
        private Integer thumb_height;

        InlineQueryResultDocumentBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder id(String id) {
            this.id = id;
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
        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder title(String title) {
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
        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        /**
         * *Required*
         * Sets the URL of the document for the result
         *
         * @param documentUrl The URL of the document for the result
         *
         * @return The builder object
         */
        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder documentUrl(URL documentUrl) {
            this.document_url = documentUrl;
            return this;
        }

        /**
         * *Required*
         * Sets the mime type of the document file. E.g. application/pdf or application/msword
         * @see <a href="http://www.freeformatter.com/mime-types-list.html">You can find a complete list of mimetypes here</a>
         *
         * @param mimeType The mimetype of the document being sent for this result
         *
         * @return The builder object
         */
        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder mimeType(String mimeType) {
            this.mime_type = mimeType;
            return this;
        }

        /**
         * *Optional*
         * Sets a short description of the result to be shown in the inline result selection pane
         *
         * @param description The description you want to be shown in the result selection pane
         *
         * @return The builder object
         */
        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder description(String description) {
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
        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
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
        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * *Optional*
         * Sets the URL of the thumbnail that should show next to the result in the inline result selection pane
         *
         * @param thumbUrl The URL of the thumbnail you want to be shown next to the result in the result selection pane
         *
         * @return The builder object
         */
        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        /**
         * *Optional*
         * Sets the width of the thumbnail at the previously provided URL through {@link #thumbUrl(URL)}
         *
         * @param thumbWidth The width of the thumbnail
         *
         * @return The builder object
         */
        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder thumbWidth(int thumbWidth) {
            this.thumb_width = thumbWidth;
            return this;
        }

        /**
         * *Optional*
         * Sets the height of the thumbnail at the previously provided URL through {@link #thumbUrl(URL)}
         *
         * @param thumbHeight The height of the thumbnail
         *
         * @return The builder object
         */
        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder thumbHeight(int thumbHeight) {
            this.thumb_height = thumbHeight;
            return this;
        }

        /**
         * Builds the InlineQueryResultDocument object
         *
         * @return An InlineQueryResultDocument object based on the previously provided values
         */
        public InlineQueryResultDocument build() {
            return new InlineQueryResultDocument(id, title, caption, document_url, mime_type, description, reply_markup, input_message_content, thumb_url, thumb_width, thumb_height);
        }
    }
}