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
public class InlineQueryResultArticle implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.ARTICLE;
    @NonNull
    private final String id;
    @NonNull
    private final String title;
    @NonNull
    private final String message_text;
    private final ParseMode parse_mode;
    private final boolean disable_web_page_preview;
    private final URL url;
    private final boolean hide_url;
    private final String description;
    private final URL thumb_url;
    private final int thumb_width;
    private final int thumb_height;

    public static InlineQueryResultArticleBuilder builder() {
        return new InlineQueryResultArticleBuilder();
    }

    public InlineQueryResultType getType() {
        return this.type;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @NonNull
    public String getTitle() {
        return this.title;
    }

    @NonNull
    public String getMessageText() {
        return this.message_text;
    }

    public ParseMode getParseMode() {
        return this.parse_mode;
    }

    public boolean isDisableWebPagePreview() {
        return this.disable_web_page_preview;
    }

    public URL getUrl() {
        return this.url;
    }

    public boolean isHideUrl() {
        return this.hide_url;
    }

    public String getDescription() {
        return this.description;
    }

    public URL getThumbUrl() {
        return this.thumb_url;
    }

    public int getThumbWidth() {
        return this.thumb_width;
    }

    public int getThumbHeight() {
        return this.thumb_height;
    }

    public static class InlineQueryResultArticleBuilder {
        private String id = Utils.generateRandomString(32);
        private String title;
        private String message_text;
        private ParseMode parse_mode;
        private boolean disable_web_page_preview;
        private URL url;
        private boolean hide_url;
        private String description;
        private URL thumb_url;
        private int thumb_width;
        private int thumb_height;

        InlineQueryResultArticleBuilder() {
        }

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder messageText(String messageText) {
            this.message_text = messageText;
            return this;
        }

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder parseMode(ParseMode parse_mode) {
            this.parse_mode = parse_mode;
            return this;
        }

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder disableWebPagePreview(boolean disableWebPagePreview) {
            this.disable_web_page_preview = disableWebPagePreview;
            return this;
        }

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder url(URL url) {
            this.url = url;
            return this;
        }

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder hideUrl(boolean hideUrl) {
            this.hide_url = hideUrl;
            return this;
        }

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder description(String description) {
            this.description = description;
            return this;
        }

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder thumbWidth(int thumb_width) {
            this.thumb_width = thumb_width;
            return this;
        }

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder thumbHeight(int thumb_height) {
            this.thumb_height = thumb_height;
            return this;
        }

        public InlineQueryResultArticle build() {
            return new InlineQueryResultArticle(id, title, message_text, parse_mode, disable_web_page_preview, url, hide_url, description, thumb_url, thumb_width, thumb_height);
        }

        public String toString() {
            return "pro.zackpollard.telegrambot.api.chat.inline.send.results.InlineQueryResultArticle.InlineQueryResultArticleBuilder(id=" + this.id + ", title=" + this.title + ", message_text=" + this.message_text + ", parse_mode=" + this.parse_mode + ", disable_web_page_preview=" + this.disable_web_page_preview + ", url=" + this.url + ", hide_url=" + this.hide_url + ", description=" + this.description + ", thumb_url=" + this.thumb_url + ", thumb_width=" + this.thumb_width + ", thumb_height=" + this.thumb_height + ")";
        }
    }
}
