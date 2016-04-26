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
public class InlineQueryResultVideo implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.VIDEO;
    @NonNull
    private final String id;
    @NonNull
    private final URL video_url;
    @NonNull
    private final String mime_type;
    @NonNull
    private final URL thumb_url;
    private final int video_width;
    private final int video_height;
    @NonNull
    private final String title;
    private final String caption;
    private final int video_duration;
    private final String description;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    public static InlineQueryResultVideoBuilder builder() {
        return new InlineQueryResultVideoBuilder();
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
    public URL getVideoUrl() {
        return this.video_url;
    }

    @NonNull
    public String getMimeType() {
        return this.mime_type;
    }

    @NonNull
    public URL getThumbUrl() {
        return this.thumb_url;
    }

    public int getVideoWidth() {
        return this.video_width;
    }

    public int getVideoHeight() {
        return this.video_height;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCaption() {
        return this.caption;
    }

    public int getVideoDuration() {
        return this.video_duration;
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
    public static class InlineQueryResultVideoBuilder {
        private String id = Utils.generateRandomString(32);
        private URL video_url;
        private String mime_type;
        private URL thumb_url;
        private int video_width;
        private int video_height;
        private String title;
        private String caption;
        private int video_duration;
        private String description;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultVideoBuilder() {
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder videoUrl(URL videoUrl) {
            this.video_url = videoUrl;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder mimeType(String mimeType) {
            this.mime_type = mimeType;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder videoWidth(int videoWidth) {
            this.video_width = videoWidth;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder videoHeight(int videoHeight) {
            this.video_height = videoHeight;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder videoDuration(int videoDuration) {
            this.video_duration = videoDuration;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder replyMarkup(InlineReplyMarkup inlineReplyMarkup) {
            this.reply_markup = inlineReplyMarkup;
            return this;
        }

        public InlineQueryResultVideo.InlineQueryResultVideoBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultVideo build() {
            return new InlineQueryResultVideo(id, video_url, mime_type, thumb_url, video_width, video_height, title, caption, video_duration, description, reply_markup, input_message_content);
        }
    }
}
