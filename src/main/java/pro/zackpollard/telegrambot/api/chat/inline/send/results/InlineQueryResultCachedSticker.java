package pro.zackpollard.telegrambot.api.chat.inline.send.results;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.InlineReplyMarkup;
import pro.zackpollard.telegrambot.api.chat.inline.send.content.InputMessageContent;

/**
 * @author zackp
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineQueryResultCachedSticker implements InlineQueryResultCached {

    private final InlineQueryResultType type = InlineQueryResultType.STICKER;
    @NonNull
    private final String id;
    @NonNull
    private final String sticker_file_id;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    public static InlineQueryResultCachedStickerBuilder builder() {
        return new InlineQueryResultCachedStickerBuilder();
    }

    @Override
    public InlineQueryResultType getType() {
        return this.type;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @NonNull
    public String getStickerFileId() {
        return this.sticker_file_id;
    }

    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
    }

    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    @ToString
    public static class InlineQueryResultCachedStickerBuilder {
        private String id;
        private String sticker_file_id;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultCachedStickerBuilder() {
        }

        public InlineQueryResultCachedSticker.InlineQueryResultCachedStickerBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultCachedSticker.InlineQueryResultCachedStickerBuilder stickerFileId(String stickerFileId) {
            this.sticker_file_id = stickerFileId;
            return this;
        }

        public InlineQueryResultCachedSticker.InlineQueryResultCachedStickerBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        public InlineQueryResultCachedSticker.InlineQueryResultCachedStickerBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultCachedSticker build() {
            return new InlineQueryResultCachedSticker(id, sticker_file_id, reply_markup, input_message_content);
        }
    }
}
