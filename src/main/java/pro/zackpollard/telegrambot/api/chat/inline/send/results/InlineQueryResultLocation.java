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
public class InlineQueryResultLocation implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.LOCATION;
    @NonNull
    private final String id;
    @NonNull
    private final Double latitude;
    @NonNull
    private final Double longitude;
    @NonNull
    private final String title;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;
    private final URL thumb_url;
    private final Integer thumb_width;
    private final Integer thumb_height;

    public static InlineQueryResultLocationBuilder builder() {
        return new InlineQueryResultLocationBuilder();
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
    public Double getLatitude() {
        return this.latitude;
    }

    @NonNull
    public Double getLongitude() {
        return this.longitude;
    }

    @NonNull
    public String getTitle() {
        return this.title;
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
    public static class InlineQueryResultLocationBuilder {
        private String id = Utils.generateRandomString(32);
        private Double latitude;
        private Double longitude;
        private String title;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;
        private URL thumb_url;
        private Integer thumb_width;
        private Integer thumb_height;

        InlineQueryResultLocationBuilder() {
        }

        public InlineQueryResultLocation.InlineQueryResultLocationBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultLocation.InlineQueryResultLocationBuilder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public InlineQueryResultLocation.InlineQueryResultLocationBuilder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public InlineQueryResultLocation.InlineQueryResultLocationBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultLocation.InlineQueryResultLocationBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        public InlineQueryResultLocation.InlineQueryResultLocationBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultLocation.InlineQueryResultLocationBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        public InlineQueryResultLocation.InlineQueryResultLocationBuilder thumbWidth(Integer thumbWidth) {
            this.thumb_width = thumbWidth;
            return this;
        }

        public InlineQueryResultLocation.InlineQueryResultLocationBuilder thumbHeight(Integer thumbHeight) {
            this.thumb_height = thumbHeight;
            return this;
        }

        public InlineQueryResultLocation build() {
            return new InlineQueryResultLocation(id, latitude, longitude, title, reply_markup, input_message_content, thumb_url, thumb_width, thumb_height);
        }
    }
}
