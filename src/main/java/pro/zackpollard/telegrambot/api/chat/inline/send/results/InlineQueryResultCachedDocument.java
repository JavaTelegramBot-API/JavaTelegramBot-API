package pro.zackpollard.telegrambot.api.chat.inline.send.results;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.inline.InlineReplyMarkup;
import pro.zackpollard.telegrambot.api.chat.inline.send.content.InputMessageContent;
import pro.zackpollard.telegrambot.api.utils.Utils;

/**
 * @author zackp
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineQueryResultCachedDocument implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.DOCUMENT;
    @NonNull
    private final String id;
    @NonNull
    private final String title;
    private final String caption;
    @NonNull
    private final String document_file_id;
    private final String description;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    public static InlineQueryResultCachedDocumentBuilder builder() {
        return new InlineQueryResultCachedDocumentBuilder();
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
    public String getDocumentFileId() {
        return this.document_file_id;
    }

    @NonNull
    public String getTitle() {
        return this.title;
    }

    public String getCaption() {
        return this.caption;
    }

    public String getDescription() {
        return this.description;
    }

    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
    }

    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    @ToString
    public static class InlineQueryResultCachedDocumentBuilder {
        private String id = Utils.generateRandomString(32);
        private String title;
        private String caption;
        private String document_file_id;
        private String description;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultCachedDocumentBuilder() {
        }

        public InlineQueryResultCachedDocumentBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultCachedDocumentBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultCachedDocumentBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public InlineQueryResultCachedDocumentBuilder documentFileId(String documentFileId) {
            this.document_file_id = documentFileId;
            return this;
        }

        public InlineQueryResultCachedDocumentBuilder description(String description) {
            this.description = description;
            return this;
        }

        public InlineQueryResultCachedDocumentBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        public InlineQueryResultCachedDocumentBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultCachedDocument build() {
            return new InlineQueryResultCachedDocument(id, title, caption, document_file_id, description, reply_markup, input_message_content);
        }
    }
}