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
public class InlineQueryResultPhoto implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.PHOTO;
    @NonNull
    private final String id;
    @NonNull
    private final URL photo_url;
    private final int photo_width;
    private final int photo_height;
    @NonNull
    private final URL thumb_url;
    private final String title;
    private final String description;
    private final String caption;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultPhotoBuilder object used to construct the InlineQueryResultPhoto object
     */
    public static InlineQueryResultPhotoBuilder builder() {
        return new InlineQueryResultPhotoBuilder();
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
     * Gets the URL of the photo
     *
     * @return The URL of the photo
     */
    @NonNull
    public URL getPhotoUrl() {
        return this.photo_url;
    }

    /**
     * Gets the width of the photo
     *
     * @return The width of the photo
     */
    public int getPhotoWidth() {
        return this.photo_width;
    }

    /**
     * Gets the height of the photo
     *
     * @return The height of the photo
     */
    public int getPhotoHeight() {
        return this.photo_height;
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
     * Gets the content of the message to be sent instead of the photo
     *
     * @return The content of the message to be sent instead of the photo
     */
    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

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

    @ToString
    public static class InlineQueryResultPhotoBuilder {
        private String id = Utils.generateRandomString(32);
        private URL photo_url;
        private int photo_width;
        private int photo_height;
        private URL thumb_url;
        private String title;
        private String description;
        private String caption;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultPhotoBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the URL of the photo for the result
         *
         * @param photoUrl The URL of the photo for the result
         *
         * @return The builder object
         */
        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder photoUrl(URL photoUrl) {
            this.photo_url = photoUrl;
            return this;
        }

        /**
         * *Optional*
         * Sets the width of the photo for the result
         *
         * @param photoWidth The width of the photo
         *
         * @return The builder object
         */
        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder photoWidth(int photoWidth) {
            this.photo_width = photoWidth;
            return this;
        }

        /**
         * *Optional*
         * Sets the height of the photo for the result
         *
         * @param photoHeight The height of the photo
         *
         * @return The builder object
         */
        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder photoHeight(int photoHeight) {
            this.photo_height = photoHeight;
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
        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder thumbUrl(URL thumbUrl) {
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
        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder title(String title) {
            this.title = title;
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
        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder description(String description) {
            this.description = description;
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
        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder caption(String caption) {
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
        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
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
        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * Builds the InlineQueryResultPhoto object
         *
         * @return An InlineQueryResultPhoto object based on the previously provided values
         */
        public InlineQueryResultPhoto build() {
            return new InlineQueryResultPhoto(id, photo_url, photo_width, photo_height, thumb_url, title, description, caption, reply_markup, input_message_content);
        }
    }
}
