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
public class InlineQueryResultGif implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.GIF;
    @NonNull
    private final String id;
    @NonNull
    private final URL gif_url;
    private final int gif_width;
    private final int gif_height;
    @NonNull
    private final URL thumb_url;
    private final String title;
    private final String caption;
    private final String message_text;
    private final ParseMode parse_mode;
    private final boolean disable_web_page_preview;

    public static InlineQueryResultGifBuilder builder() {
        return new InlineQueryResultGifBuilder();
    }

    public InlineQueryResultType getType() {
        return this.type;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @NonNull
    public URL getGifUrl() {
        return this.gif_url;
    }

    public int getGifWidth() {
        return this.gif_width;
    }

    public int getGifHeight() {
        return this.gif_height;
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

    public static class InlineQueryResultGifBuilder {
        private String id = Utils.generateRandomString(32);
        private URL gif_url;
        private int gif_width;
        private int gif_height;
        private URL thumb_url;
        private String title;
        private String caption;
        private String message_text;
        private ParseMode parse_mode;
        private boolean disable_web_page_preview;

        InlineQueryResultGifBuilder() {
        }

        public InlineQueryResultGif.InlineQueryResultGifBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultGif.InlineQueryResultGifBuilder gifUrl(URL gifUrl) {
            this.gif_url = gifUrl;
            return this;
        }

        public InlineQueryResultGif.InlineQueryResultGifBuilder gifWidth(int gifWidth) {
            this.gif_width = gifWidth;
            return this;
        }

        public InlineQueryResultGif.InlineQueryResultGifBuilder gifHeight(int gifHeight) {
            this.gif_height = gifHeight;
            return this;
        }

        public InlineQueryResultGif.InlineQueryResultGifBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        public InlineQueryResultGif.InlineQueryResultGifBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultGif.InlineQueryResultGifBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public InlineQueryResultGif.InlineQueryResultGifBuilder messageText(String messageText) {
            this.message_text = messageText;
            return this;
        }

        public InlineQueryResultGif.InlineQueryResultGifBuilder parseMode(ParseMode parseMode) {
            this.parse_mode = parseMode;
            return this;
        }

        public InlineQueryResultGif.InlineQueryResultGifBuilder disableWebPagePreview(boolean disableWebPagePreview) {
            this.disable_web_page_preview = disableWebPagePreview;
            return this;
        }

        public InlineQueryResultGif build() {
            return new InlineQueryResultGif(id, gif_url, gif_width, gif_height, thumb_url, title, caption, message_text, parse_mode, disable_web_page_preview);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResultGif.InlineQueryResultGifBuilder(id=" + this.id + ", gif_url=" + this.gif_url + ", gif_width=" + this.gif_width + ", gif_height=" + this.gif_height + ", thumb_url=" + this.thumb_url + ", title=" + this.title + ", caption=" + this.caption + ", message_text=" + this.message_text + ", parse_mode=" + this.parse_mode + ", disable_web_page_preview=" + this.disable_web_page_preview + ")";
        }
    }
}
