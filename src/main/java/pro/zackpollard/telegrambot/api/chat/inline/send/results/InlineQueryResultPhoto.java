package pro.zackpollard.telegrambot.api.chat.inline.send.results;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.ParseMode;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.net.URL;

/**
 * @author Zack Pollard
 */
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
    private final String caption;
    private final String message_text;
    private final ParseMode parse_mode;
    private final boolean disable_web_page_preview;

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

    public String getMessageText() {
        return this.message_text;
    }

    public ParseMode getParseMode() {
        return this.parse_mode;
    }

    public boolean isDisableWebPagePreview() {
        return this.disable_web_page_preview;
    }

    public static class InlineQueryResultPhotoBuilder {
        private String id = Utils.generateRandomString(32);
        private URL photo_url;
        private int photo_width;
        private int photo_height;
        private URL thumb_url;
        private String title;
        private String caption;
        private String message_text;
        private ParseMode parse_mode;
        private boolean disable_web_page_preview;

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

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder messageText(String messageText) {
            this.message_text = messageText;
            return this;
        }

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder parseMode(ParseMode parseMode) {
            this.parse_mode = parseMode;
            return this;
        }

        public InlineQueryResultPhoto.InlineQueryResultPhotoBuilder disableWebPagePreview(boolean disableWebPagePreview) {
            this.disable_web_page_preview = disableWebPagePreview;
            return this;
        }

        public InlineQueryResultPhoto build() {
            return new InlineQueryResultPhoto(id, photo_url, photo_width, photo_height, thumb_url, title, caption, message_text, parse_mode, disable_web_page_preview);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResultPhoto.InlineQueryResultPhotoBuilder(id=" + this.id + ", photo_url=" + this.photo_url + ", photo_width=" + this.photo_width + ", photo_height=" + this.photo_height + ", thumb_url=" + this.thumb_url + ", title=" + this.title + ", caption=" + this.caption + ", message_text=" + this.message_text + ", parse_mode=" + this.parse_mode + ", disable_web_page_preview=" + this.disable_web_page_preview + ")";
        }
    }
}
