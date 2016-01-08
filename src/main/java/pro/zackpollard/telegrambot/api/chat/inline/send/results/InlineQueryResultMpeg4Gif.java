package pro.zackpollard.telegrambot.api.chat.inline.send.results;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pro.zackpollard.telegrambot.api.chat.message.send.ParseMode;
import pro.zackpollard.telegrambot.api.utils.Utils;

import java.net.URL;

/**
 * @author Zack Pollard
 */
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
    private final String message_text;
    private final ParseMode parse_mode;
    private final boolean disable_web_page_preview;

    public static InlineQueryResultMpeg4GifBuilder builder() {
        return new InlineQueryResultMpeg4GifBuilder();
    }

    public InlineQueryResultType getType() {
        return this.type;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @NonNull
    public URL getMpeg4Url() {
        return this.mpeg4_url;
    }

    public int getMpeg4Width() {
        return this.mpeg4_width;
    }

    public int getMpeg4Height() {
        return this.mpeg4_height;
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

    public static class InlineQueryResultMpeg4GifBuilder {
        private String id = Utils.generateRandomString(32);
        private URL mpeg4_url;
        private int mpeg4_width;
        private int mpeg4_height;
        private URL thumb_url;
        private String title;
        private String caption;
        private String message_text;
        private ParseMode parse_mode;
        private boolean disable_web_page_preview;

        InlineQueryResultMpeg4GifBuilder() {
        }

        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder mpeg4Url(URL mpeg4Url) {
            this.mpeg4_url = mpeg4Url;
            return this;
        }

        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder mpeg4Width(int mpeg4Width) {
            this.mpeg4_width = mpeg4Width;
            return this;
        }

        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder mpeg4Height(int mpeg4Height) {
            this.mpeg4_height = mpeg4Height;
            return this;
        }

        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder messageText(String messageText) {
            this.message_text = messageText;
            return this;
        }

        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder parseMode(ParseMode parseMode) {
            this.parse_mode = parseMode;
            return this;
        }

        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder disableWebPagePreview(boolean disableWebPagePreview) {
            this.disable_web_page_preview = disableWebPagePreview;
            return this;
        }

        public InlineQueryResultMpeg4Gif build() {
            return new InlineQueryResultMpeg4Gif(id, mpeg4_url, mpeg4_width, mpeg4_height, thumb_url, title, caption, message_text, parse_mode, disable_web_page_preview);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder(id=" + this.id + ", mpeg4_url=" + this.mpeg4_url + ", mpeg4_width=" + this.mpeg4_width + ", mpeg4_height=" + this.mpeg4_height + ", thumb_url=" + this.thumb_url + ", title=" + this.title + ", caption=" + this.caption + ", message_text=" + this.message_text + ", parse_mode=" + this.parse_mode + ", disable_web_page_preview=" + this.disable_web_page_preview + ")";
        }
    }
}
