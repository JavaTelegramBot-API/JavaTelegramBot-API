package pro.zackpollard.telegrambot.api.chat.inline.send.results;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.send.ParseMode;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.net.URL;

/**
 * @author Zack Pollard
 */
@RequiredArgsConstructor
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
    private final String title;
    private final String caption;
    private final String message_text;
    private final ParseMode parse_mode;
    private final boolean disable_web_page_preview;

    public static InlineQueryResultVideoBuilder builder() {
        return new InlineQueryResultVideoBuilder();
    }

    @Override
    public InlineQueryResultType getType() {
        return InlineQueryResultType.VIDEO;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @NonNull
    public URL getVideoUrl() {
        return this.video_url;
    }

    @NonNull
    public String getMimeType() {
        return this.mime_type;
    }

    @NonNull
    public URL getThumbUrl() {
        return this.thumb_url;
    }

    public int getVideoWidth() {
        return this.video_width;
    }

    public int getVideoHeight() {
        return this.video_height;
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

    public static class InlineQueryResultVideoBuilder {
        private String id = Utils.generateRandomString(32);
        private URL video_url;
        private String mime_type;
        private URL thumb_url;
        private int video_width;
        private int video_height;
        private String title;
        private String caption;
        private String message_text;
        private ParseMode parse_mode;
        private boolean disable_web_page_preview;

        InlineQueryResultVideoBuilder() {
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder videoUrl(URL videoUrl) {
            this.video_url = videoUrl;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder mimeType(String mimeType) {
            this.mime_type = mimeType;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder videoWidth(int videoWidth) {
            this.video_width = videoWidth;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder videoHeight(int videoHeight) {
            this.video_height = videoHeight;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder messageText(String messageText) {
            this.message_text = messageText;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder parseMode(ParseMode parseMode) {
            this.parse_mode = parseMode;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder disableWebPagePreview(boolean disableWebPagePreview) {
            this.disable_web_page_preview = disableWebPagePreview;
            return this;
        }

        public InlineQueryResultVideo build() {
            return new InlineQueryResultVideo(id, video_url, mime_type, thumb_url, video_width, video_height, title, caption, message_text, parse_mode, disable_web_page_preview);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResultVideo.InlineQueryResultVideoBuilder(id=" + this.id + ", video_url=" + this.video_url + ", mime_type=" + this.mime_type + ", thumb_url=" + this.thumb_url + ", video_width=" + this.video_width + ", video_height=" + this.video_height + ", title=" + this.title + ", caption=" + this.caption + ", message_text=" + this.message_text + ", parse_mode=" + this.parse_mode + ", disable_web_page_preview=" + this.disable_web_page_preview + ")";
        }
    }
}
