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
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

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

    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
    }

    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    @ToString
    public static class InlineQueryResultGifBuilder {
        private String id = Utils.generateRandomString(32);
        private URL gif_url;
        private int gif_width;
        private int gif_height;
        private URL thumb_url;
        private String title;
        private String caption;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

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

        public InlineQueryResultGif.InlineQueryResultGifBuilder replyMarkup(InlineReplyMarkup inlineReplyMarkup) {
            this.reply_markup = inlineReplyMarkup;
            return this;
        }

        public InlineQueryResultGif.InlineQueryResultGifBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultGif build() {
            return new InlineQueryResultGif(id, gif_url, gif_width, gif_height, thumb_url, title, caption, reply_markup, input_message_content);
        }
    }
}
