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
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineQueryResultArticle implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.ARTICLE;
    @NonNull
    private final String id;
    @NonNull
    private final String title;
    @NonNull
    private final InputMessageContent input_message_content;
    private final InlineReplyMarkup reply_markup;
    private final URL url;
    private final boolean hide_url;
    private final String description;
    private final URL thumb_url;
    private final int thumb_width;
    private final int thumb_height;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultArticleBuilder object used to construct the InlineQueryResultArticle object
     */
    public static InlineQueryResultArticleBuilder builder() {
        return new InlineQueryResultArticleBuilder();
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
     * Gets the title of the result
     *
     * @return The title of the result
     */
    @NonNull
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the content of the message to be sent
     *
     * @return The content of the message to be sent
     */
    public InputMessageContent getContent() {
        return this.input_message_content;
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
     * Gets the URL of the result
     *
     * @return URL of the result
     */
    public URL getUrl() {
        return this.url;
    }

    /**
     * Gets whether the URL should be hidden in the message
     *
     * @return True if the URL should be hidden in the message, otherwise False
     */
    public boolean isHideUrl() {
        return this.hide_url;
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
    public static class InlineQueryResultArticleBuilder {

        private String id = Utils.generateRandomString(32);
        private String title;
        private InputMessageContent input_message_content;
        private InlineReplyMarkup reply_markup;
        private URL url;
        private boolean hide_url;
        private String description;
        private URL thumb_url;
        private int thumb_width;
        private int thumb_height;

        InlineQueryResultArticleBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultArticle.InlineQueryResultArticleBuilder id(String id) {
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
        public InlineQueryResultArticle.InlineQueryResultArticleBuilder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * *Required*
         * Sets the content you want to be sent with this result to the provided InputMessageContent object
         *
         * @param inputMessageContent The content you want to be sent with the result
         *
         * @return The builder object
         */
        public InlineQueryResultArticle.InlineQueryResultArticleBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
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
        public InlineQueryResultArticle.InlineQueryResultArticleBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        /**
         * *Optional*
         * Sets the URL of the result
         *
         * @param url The URL of the result
         *
         * @return The builder object
         */
        public InlineQueryResultArticle.InlineQueryResultArticleBuilder url(URL url) {
            this.url = url;
            return this;
        }

        /**
         * *Optional*
         * Sets whether to hide the URL when the message is sent. Defaults to false
         *
         * @param hideUrl True to hide the URL, otherwise False
         *
         * @return The builder object
         */
        public InlineQueryResultArticle.InlineQueryResultArticleBuilder hideUrl(boolean hideUrl) {
            this.hide_url = hideUrl;
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
        public InlineQueryResultArticle.InlineQueryResultArticleBuilder description(String description) {
            this.description = description;
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
        public InlineQueryResultArticle.InlineQueryResultArticleBuilder thumbUrl(URL thumbUrl) {
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
        public InlineQueryResultArticle.InlineQueryResultArticleBuilder thumbWidth(int thumbWidth) {
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
        public InlineQueryResultArticle.InlineQueryResultArticleBuilder thumbHeight(int thumbHeight) {
            this.thumb_height = thumbHeight;
            return this;
        }

        /**
         * Builds the InlineQueryResultArticle object
         *
         * @return An InlineQueryResultArticle object based on the previously provided values
         */
        public InlineQueryResultArticle build() {
            return new InlineQueryResultArticle(id, title, input_message_content, reply_markup, url, hide_url, description, thumb_url, thumb_width, thumb_height);
        }
    }
}
