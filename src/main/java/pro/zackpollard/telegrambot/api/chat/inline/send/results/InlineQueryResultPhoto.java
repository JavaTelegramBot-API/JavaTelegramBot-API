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

    public InlineQueryResultType getType() {
        return this.type;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @NonNull
    public URL getPhotoUrl() {
        return this.photo_url;
    }

    public int getPhotoWidth() {
        return this.photo_width;
    }

    public int getPhotoHeight() {
        return this.photo_height;
    }

    @NonNull
    public URL getThumbUrl() {
        return this.thumb_url;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCaption() {
        return this.caption;
    }

    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    public String getDescription() {
        return this.description;
    }

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

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder photoUrl(URL photoUrl) {
            this.photo_url = photoUrl;
            return this;
        }

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder photoWidth(int photoWidth) {
            this.photo_width = photoWidth;
            return this;
        }

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder photoHeight(int photoHeight) {
            this.photo_height = photoHeight;
            return this;
        }

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultPhoto build() {
            return new InlineQueryResultPhoto(id, photo_url, photo_width, photo_height, thumb_url, title, description, caption, reply_markup, input_message_content);
        }
    }
}
