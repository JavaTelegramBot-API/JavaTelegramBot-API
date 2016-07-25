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
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultMpeg4GifBuilder object used to construct the InlineQueryResultMpeg4Gif object
     */
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

    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
    }

    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    @ToString
    public static class InlineQueryResultMpeg4GifBuilder {
        private String id = Utils.generateRandomString(32);
        private URL mpeg4_url;
        private int mpeg4_width;
        private int mpeg4_height;
        private URL thumb_url;
        private String title;
        private String caption;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

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

        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder replyMarkup(InlineReplyMarkup inlineReplyMarkup) {
            this.reply_markup = inlineReplyMarkup;
            return this;
        }

        public InlineQueryResultMpeg4Gif.InlineQueryResultMpeg4GifBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultMpeg4Gif build() {
            return new InlineQueryResultMpeg4Gif(id, mpeg4_url, mpeg4_width, mpeg4_height, thumb_url, title, caption, reply_markup, input_message_content);
        }
    }
}
