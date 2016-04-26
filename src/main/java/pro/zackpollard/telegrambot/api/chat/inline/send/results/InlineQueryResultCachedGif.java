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
public class InlineQueryResultCachedGif implements InlineQueryResultCached {

    private final InlineQueryResultType type = InlineQueryResultType.GIF;
    @NonNull
    private final String id;
    @NonNull
    private final String gif_file_id;
    private final String title;
    private final String caption;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    public static InlineQueryResultCachedGifBuilder builder() {
        return new InlineQueryResultCachedGifBuilder();
    }

    public InlineQueryResultType getType() {
        return this.type;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @NonNull
    public String getGifFileId() {
        return this.gif_file_id;
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
    public static class InlineQueryResultCachedGifBuilder {
        private String id = Utils.generateRandomString(32);
        private String gif_file_id;
        private String title;
        private String caption;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultCachedGifBuilder() {
        }

        public InlineQueryResultCachedGifBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultCachedGifBuilder gifFileId(String gifFileId) {
            this.gif_file_id = gifFileId;
            return this;
        }

        public InlineQueryResultCachedGifBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultCachedGifBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public InlineQueryResultCachedGifBuilder replyMarkup(InlineReplyMarkup inlineReplyMarkup) {
            this.reply_markup = inlineReplyMarkup;
            return this;
        }

        public InlineQueryResultCachedGifBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultCachedGif build() {
            return new InlineQueryResultCachedGif(id, gif_file_id, title, caption, reply_markup, input_message_content);
        }
    }
}
