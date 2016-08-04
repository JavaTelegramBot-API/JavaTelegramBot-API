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
public class InlineQueryResultMpeg4Gif implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.MPEG4_GIF;
    @NonNull
    private final String id;
    @NonNull
    private final URL mpeg4_url;
    private final int mpeg4_width;
    private final int mpeg4_height;
    @NonNull
    private final URL thumb_url;
    private final String title;
    private final String caption;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultMpeg4GifBuilder object used to construct the InlineQueryResultMpeg4Gif object
     */
    public static InlineQueryResultMpeg4GifBuilder builder() {
        return new InlineQueryResultMpeg4GifBuilder();
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
     * Gets the URL of the mpeg4gif
     *
     * @return The URL of the mpeg4gif
     */
    @NonNull
    public URL getMpeg4Url() {
        return this.mpeg4_url;
    }

    /**
     * Gets the width of the mpeg4gif
     *
     * @return The width of the mpeg4gif
     */
    public int getMpeg4Width() {
        return this.mpeg4_width;
    }

    /**
     * Gets the height of the mpeg4gif
     *
     * @return The height of the mpeg4gif
     */
    public int getMpeg4Height() {
        return this.mpeg4_height;
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
     * Gets the content of the message to be sent instead of the video animation
     *
     * @return The content of the message to be sent instead of the video animation
     */
    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    @ToString
    public static class InlineQueryResultMpeg4GifBuilder {
        private String id = Utils.generateRandomString(32);
        private URL mpeg4_url;
        private int mpeg4_width;
        private int mpeg4_height;
        private URL thumb_url;
        private String title;
        private String caption;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultMpeg4GifBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the URL of the mpeg4gif for the result
         *
         * @param mpeg4Url The URL of the mpeg4gif for the result
         *
         * @return The builder object
         */
        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder mpeg4Url(URL mpeg4Url) {
            this.mpeg4_url = mpeg4Url;
            return this;
        }

        /**
         * *Optional*
         * Sets the width of the mpeg4gif for the result
         *
         * @param mpeg4Width The width of the mpeg4gif
         *
         * @return The builder object
         */
        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder mpeg4Width(int mpeg4Width) {
            this.mpeg4_width = mpeg4Width;
            return this;
        }

        /**
         * *Optional*
         * Sets the height of the mpeg4gif for the result
         *
         * @param mpeg4Height The height of the mpeg4gif
         *
         * @return The builder object
         */
        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder mpeg4Height(int mpeg4Height) {
            this.mpeg4_height = mpeg4Height;
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
        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder thumbUrl(URL thumbUrl) {
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
        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder title(String title) {
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
        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder caption(String caption) {
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
        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
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
        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * Builds the InlineQueryResultMpeg4Gif object
         *
         * @return An InlineQueryResultMpeg4Gif object based on the previously provided values
         */
        public InlineQueryResultMpeg4Gif build() {
            return new InlineQueryResultMpeg4Gif(id, mpeg4_url, mpeg4_width, mpeg4_height, thumb_url, title, caption, reply_markup, input_message_content);
        }
    }
}
