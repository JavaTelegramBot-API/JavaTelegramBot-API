package pro.zackpollard.telegrambot.api.chat.inline.send.results;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.InlineReplyMarkup;
import pro.zackpollard.telegrambot.api.chat.inline.send.content.InputMessageContent;
import pro.zackpollard.telegrambot.api.utils.Utils;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineQueryResultCachedMpeg4Gif implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.MPEG4_GIF;
    @NonNull
    private final String id;
    @NonNull
    private final String mpeg4_file_id;
    private final String title;
    private final String caption;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    public static InlineQueryResultCachedMpeg4GifBuilder builder() {
        return new InlineQueryResultCachedMpeg4GifBuilder();
    }

    public InlineQueryResultType getType() {
        return this.type;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @NonNull
    public String getMpeg4FileId() {
        return this.mpeg4_file_id;
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
    public static class InlineQueryResultCachedMpeg4GifBuilder {
        private String id = Utils.generateRandomString(32);
        private String mpeg4_file_id;
        private String title;
        private String caption;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultCachedMpeg4GifBuilder() {
        }

        public InlineQueryResultCachedMpeg4GifBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultCachedMpeg4GifBuilder mpeg4FileId(String mpeg4FileId) {
            this.mpeg4_file_id = mpeg4FileId;
            return this;
        }

        public InlineQueryResultCachedMpeg4GifBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultCachedMpeg4GifBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public InlineQueryResultCachedMpeg4GifBuilder replyMarkup(InlineReplyMarkup inlineReplyMarkup) {
            this.reply_markup = inlineReplyMarkup;
            return this;
        }

        public InlineQueryResultCachedMpeg4GifBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultCachedMpeg4Gif build() {
            return new InlineQueryResultCachedMpeg4Gif(id, mpeg4_file_id, title, caption, reply_markup, input_message_content);
        }
    }
}
