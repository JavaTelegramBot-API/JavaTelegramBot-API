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
public class InlineQueryResultArticle implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.ARTICLE;
    @NonNull
    private final String id;
    @NonNull
    private final String title;
    @NonNull
    private final InputMessageContent input_message_content;
    private final InlineReplyMarkup reply_markup;
    private final URL url;
    private final boolean hide_url;
    private final String description;
    private final URL thumb_url;
    private final int thumb_width;
    private final int thumb_height;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultArticleBuilder object used to construct the InlineQueryResultArticle object
     */
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

    public InputMessageContent getContent() {
        return this.input_message_content;
    }

    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
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

    @ToString
    public static class InlineQueryResultArticleBuilder {
        private String id = Utils.generateRandomString(32);
        private String title;
        private InputMessageContent input_message_content;
        private InlineReplyMarkup reply_markup;
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

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultArticle.InlineQueryResultArticleBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
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
            return new InlineQueryResultArticle(id, title, input_message_content, reply_markup, url, hide_url, description, thumb_url, thumb_width, thumb_height);
        }
    }
}
