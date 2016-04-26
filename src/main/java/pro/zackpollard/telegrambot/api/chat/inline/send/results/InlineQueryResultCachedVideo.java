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
public class InlineQueryResultCachedVideo implements InlineQueryResultCached {

    private final InlineQueryResultType type = InlineQueryResultType.VIDEO;
    @NonNull
    private final String id;
    @NonNull
    private final String video_file_id;
    @NonNull
    private final String title;
    private final String caption;
    private final String description;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    public static InlineQueryResultCachedVideoBuilder builder() {
        return new InlineQueryResultCachedVideoBuilder();
    }

    @Override
    public InlineQueryResultType getType() {
        return this.type;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

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
    public static class InlineQueryResultCachedVideoBuilder {
        private String id = Utils.generateRandomString(32);
        private String video_file_id;
        private String title;
        private String caption;
        private String description;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultCachedVideoBuilder() {
        }

        public InlineQueryResultCachedVideoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultCachedVideoBuilder videoFileId(String videoFileId) {
            this.video_file_id = videoFileId;
            return this;
        }
        public InlineQueryResultCachedVideoBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultCachedVideoBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public InlineQueryResultCachedVideoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public InlineQueryResultCachedVideoBuilder replyMarkup(InlineReplyMarkup inlineReplyMarkup) {
            this.reply_markup = inlineReplyMarkup;
            return this;
        }

        public InlineQueryResultCachedVideoBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultCachedVideo build() {
            return new InlineQueryResultCachedVideo(id, video_file_id, title, caption, description, reply_markup, input_message_content);
        }
    }
}
