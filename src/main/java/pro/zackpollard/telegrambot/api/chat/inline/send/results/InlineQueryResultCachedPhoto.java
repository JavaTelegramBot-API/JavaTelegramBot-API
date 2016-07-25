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
public class InlineQueryResultCachedPhoto implements InlineQueryResultCached {

    private final InlineQueryResultType type = InlineQueryResultType.PHOTO;
    @NonNull
    private final String id;
    @NonNull
    private final String photo_file_id;
    private final String title;
    private final String description;
    private final String caption;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultCachedPhotoBuilder object used to construct the InlineQueryResultCachedPhoto object
     */
    public static InlineQueryResultCachedPhotoBuilder builder() {
        return new InlineQueryResultCachedPhotoBuilder();
    }

    public InlineQueryResultType getType() {
        return this.type;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @NonNull
    public String getPhotoFileId() {
        return this.photo_file_id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCaption() {
        return this.caption;
    }

    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    public String getDescription() {
        return this.description;
    }

    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
    }

    @ToString
    public static class InlineQueryResultCachedPhotoBuilder {
        private String id = Utils.generateRandomString(32);
        private String photo_file_id;
        private String title;
        private String description;
        private String caption;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultCachedPhotoBuilder() {
        }

        public InlineQueryResultCachedPhotoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultCachedPhotoBuilder photoFileId(String photoFileId) {
            this.photo_file_id = photoFileId;
            return this;
        }

        public InlineQueryResultCachedPhotoBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultCachedPhotoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public InlineQueryResultCachedPhotoBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public InlineQueryResultCachedPhotoBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        public InlineQueryResultCachedPhotoBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultCachedPhoto build() {
            return new InlineQueryResultCachedPhoto(id, photo_file_id, title, description, caption, reply_markup, input_message_content);
        }
    }
}
