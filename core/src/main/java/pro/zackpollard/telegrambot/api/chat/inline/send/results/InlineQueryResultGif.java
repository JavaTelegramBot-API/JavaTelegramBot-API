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
public class InlineQueryResultGif implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.GIF;
    @NonNull
    private final String id;
    @NonNull
    private final URL gif_url;
    private final Integer gif_width;
    private final Integer gif_height;
    private final Integer gif_duration;
    @NonNull
    private final URL thumb_url;
    private final String title;
    private final String caption;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultGifBuilder object used to construct the InlineQueryResultGif object
     */
    public static InlineQueryResultGifBuilder builder() {
        return new InlineQueryResultGifBuilder();
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
     * Gets the URL of the gif
     *
     * @return The URL of the gif
     */
    @NonNull
    public URL getGifUrl() {
        return this.gif_url;
    }

    /**
     * Gets the width of the gif
     *
     * @return The width of the gif, or null if not specified
     */
    public int getGifWidth() {
        return this.gif_width;
    }

    /**
     * Gets the height of the gif
     *
     * @return The height of the gif, or null if not specified
     */
    public int getGifHeight() {
        return this.gif_height;
    }

    /**
     * Gets the duration of the gif
     * 
     * @return The duration of the gif, or null if not specified
     */
    public int getGifDuration() {
        return this.gif_duration;
    }

    /**
     * Gets the URL of the thumbnail for the result
     *
     * @return The URL of the thumbnail for the result
     */
    @NonNull
    public URL getThumbUrl() {
        return this.thumb_url;
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
     * Gets the content of the message to be sent instead of the gif animation
     *
     * @return The content of the message to be sent instead of the gif animation
     */
    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    @ToString
    public static class InlineQueryResultGifBuilder {
        private String id = Utils.generateRandomString(32);
        private URL gif_url;
        private Integer gif_width;
        private Integer gif_height;
        private Integer gif_duration;
        private URL thumb_url;
        private String title;
        private String caption;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultGifBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultGif.InlineQueryResultGifBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the URL of the gif for the result
         *
         * @param gifUrl The URL of the gif for the result
         *
         * @return The builder object
         */
        public InlineQueryResultGif.InlineQueryResultGifBuilder gifUrl(URL gifUrl) {
            this.gif_url = gifUrl;
            return this;
        }

        /**
         * *Optional*
         * Sets the width of the gif for the result
         *
         * @param gifWidth The width of the gif
         *
         * @return The builder object
         */
        public InlineQueryResultGif.InlineQueryResultGifBuilder gifWidth(Integer gifWidth) {
            this.gif_width = gifWidth;
            return this;
        }

        /**
         * *Optional*
         * Sets the height of the gif for the result
         *
         * @param gifHeight The height of the gif
         *
         * @return The builder object
         */
        public InlineQueryResultGif.InlineQueryResultGifBuilder gifHeight(Integer gifHeight) {
            this.gif_height = gifHeight;
            return this;
        }

        /**
         * *Optional*
         * Sets the duration of the gif for the result
         *
         * @param gifDuration The duration of the gif
         *
         * @return The builder object
         */
        public InlineQueryResultGif.InlineQueryResultGifBuilder gifDuration(Integer gifDuration) {
            this.gif_duration = gifDuration;
            return this;
        }

        /**
         * *Required*
         * Sets the URL of the thumbnail that should show next to the result in the inline result selection pane
         *
         * @param thumbUrl The URL of the thumbnail you want to be shown next to the result in the result selection pane
         *
         * @return The builder object
         */
        public InlineQueryResultGif.InlineQueryResultGifBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
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
        public InlineQueryResultGif.InlineQueryResultGifBuilder title(String title) {
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
        public InlineQueryResultGif.InlineQueryResultGifBuilder caption(String caption) {
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
        public InlineQueryResultGif.InlineQueryResultGifBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
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
        public InlineQueryResultGif.InlineQueryResultGifBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * Builds the InlineQueryResultGif object
         *
         * @return An InlineQueryResultGif object based on the previously provided values
         */
        public InlineQueryResultGif build() {
            return new InlineQueryResultGif(id, gif_url, gif_width, gif_height, gif_duration, thumb_url, title, caption, reply_markup, input_message_content);
        }
    }
}
