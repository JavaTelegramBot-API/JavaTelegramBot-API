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
 * @author zackp
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InlineQueryResultDocument implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.DOCUMENT;
    @NonNull
    private final String id;
    @NonNull
    private final String title;
    private final String caption;
    @NonNull
    private final URL document_url;
    @NonNull
    private final String mime_type;
    private final String description;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;
    private final URL thumb_url;
    private final Integer thumb_width;
    private final Integer thumb_height;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultDocumentBuilder object used to construct the InlineQueryResultDocument object
     */
    public static InlineQueryResultDocumentBuilder builder() {
        return new InlineQueryResultDocumentBuilder();
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
    public String getTitle() {
        return this.title;
    }

    public String getCaption() {
        return this.caption;
    }

    @NonNull
    public URL getDocumentUrl() {
        return this.document_url;
    }

    @NonNull
    public String getMimeType() {
        return this.mime_type;
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

    public URL getThumbUrl() {
        return this.thumb_url;
    }

    public Integer getThumbWidth() {
        return this.thumb_width;
    }

    public Integer getThumbHeight() {
        return this.thumb_height;
    }

    @ToString
    public static class InlineQueryResultDocumentBuilder {
        private String id = Utils.generateRandomString(32);
        private String title;
        private String caption;
        private URL document_url;
        private String mime_type;
        private String description;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;
        private URL thumb_url;
        private Integer thumb_width;
        private Integer thumb_height;

        InlineQueryResultDocumentBuilder() {
        }

        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder documentUrl(URL documentUrl) {
            this.document_url = documentUrl;
            return this;
        }

        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder mimeType(String mimeType) {
            this.mime_type = mimeType;
            return this;
        }

        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder description(String description) {
            this.description = description;
            return this;
        }

        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder thumbWidth(Integer thumbWidth) {
            this.thumb_width = thumbWidth;
            return this;
        }

        public InlineQueryResultDocument.InlineQueryResultDocumentBuilder thumbHeight(Integer thumbHeight) {
            this.thumb_height = thumbHeight;
            return this;
        }

        public InlineQueryResultDocument build() {
            return new InlineQueryResultDocument(id, title, caption, document_url, mime_type, description, reply_markup, input_message_content, thumb_url, thumb_width, thumb_height);
        }
    }
}