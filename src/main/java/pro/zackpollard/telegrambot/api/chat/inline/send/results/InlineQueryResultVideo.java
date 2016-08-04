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
public class InlineQueryResultVideo implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.VIDEO;
    @NonNull
    private final String id;
    @NonNull
    private final URL video_url;
    @NonNull
    private final String mime_type;
    @NonNull
    private final URL thumb_url;
    private final int video_width;
    private final int video_height;
    @NonNull
    private final String title;
    private final String caption;
    private final int video_duration;
    private final String description;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultVideoBuilder object used to construct the InlineQueryResultVideo object
     */
    public static InlineQueryResultVideoBuilder builder() {
        return new InlineQueryResultVideoBuilder();
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
     * Gets the URL of the video
     *
     * @return The URL of the video
     */
    @NonNull
    public URL getVideoUrl() {
        return this.video_url;
    }

    /**
     * Gets the mime type of the video file. E.g. video/mpeg4 or video/avi
     * @see <a href="http://www.freeformatter.com/mime-types-list.html">You can find a complete list of mimetypes here</a>
     *
     * @return The mime type of the document
     */
    @NonNull
    public String getMimeType() {
        return this.mime_type;
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
     * Gets the width of the video
     *
     * @return The width of the video
     */
    public int getVideoWidth() {
        return this.video_width;
    }

    /**
     * Gets the height of the video
     *
     * @return The height of the video
     */
    public int getVideoHeight() {
        return this.video_height;
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
     * Gets the duration of the video
     *
     * @return The duration of the video
     */
    public int getVideoDuration() {
        return this.video_duration;
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
    public static class InlineQueryResultVideoBuilder {
        private String id = Utils.generateRandomString(32);
        private URL video_url;
        private String mime_type;
        private URL thumb_url;
        private int video_width;
        private int video_height;
        private String title;
        private String caption;
        private int video_duration;
        private String description;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultVideoBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultVideo.InlineQueryResultVideoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the URL of the video for the result
         *
         * @param videoUrl The URL of the video for the result
         *
         * @return The builder object
         */
        public InlineQueryResultVideo.InlineQueryResultVideoBuilder videoUrl(URL videoUrl) {
            this.video_url = videoUrl;
            return this;
        }

        /**
         * *Required*
         * Sets the mime type of the video file. E.g. video/mpeg4 or video/avi
         * @see <a href="http://www.freeformatter.com/mime-types-list.html">You can find a complete list of mimetypes here</a>
         *
         * @param mimeType The mimetype of the video being sent for this result
         *
         * @return The builder object
         */
        public InlineQueryResultVideo.InlineQueryResultVideoBuilder mimeType(String mimeType) {
            this.mime_type = mimeType;
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
        public InlineQueryResultVideo.InlineQueryResultVideoBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        /**
         * *Optional*
         * Sets the width of the video file being sent for this result
         *
         * @param videoWidth The width of the video file
         *
         * @return The builder object
         */
        public InlineQueryResultVideo.InlineQueryResultVideoBuilder videoWidth(int videoWidth) {
            this.video_width = videoWidth;
            return this;
        }

        /**
         * *Optional*
         * Sets the height of the video file being sent for this result
         *
         * @param videoHeight The height of the video file
         *
         * @return The builder object
         */
        public InlineQueryResultVideo.InlineQueryResultVideoBuilder videoHeight(int videoHeight) {
            this.video_height = videoHeight;
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
        public InlineQueryResultVideo.InlineQueryResultVideoBuilder title(String title) {
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
        public InlineQueryResultVideo.InlineQueryResultVideoBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        /**
         * *Optional*
         * Sets the duration of the video file being sent for this result
         *
         * @param videoDuration The duration of the video file
         *
         * @return The builder object
         */
        public InlineQueryResultVideo.InlineQueryResultVideoBuilder videoDuration(int videoDuration) {
            this.video_duration = videoDuration;
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
        public InlineQueryResultVideo.InlineQueryResultVideoBuilder description(String description) {
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
        public InlineQueryResultVideo.InlineQueryResultVideoBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
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
        public InlineQueryResultVideo.InlineQueryResultVideoBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * Builds the InlineQueryResultVideo object
         *
         * @return An InlineQueryResultVideo object based on the previously provided values
         */
        public InlineQueryResultVideo build() {
            return new InlineQueryResultVideo(id, video_url, mime_type, thumb_url, video_width, video_height, title, caption, video_duration, description, reply_markup, input_message_content);
        }
    }
}
