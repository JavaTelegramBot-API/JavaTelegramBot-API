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
public class InlineQueryResultAudio implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.AUDIO;
    @NonNull
    private final String id;
    @NonNull
    private final URL audio_url;
    @NonNull
    private final String title;
    private final String performer;
    private final Integer audio_duration;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultAudioBuilder object used to construct the InlineQueryResultAudio object
     */
    public static InlineQueryResultAudioBuilder builder() {
        return new InlineQueryResultAudioBuilder();
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
    public URL getAudioUrl() {
        return this.audio_url;
    }

    @NonNull
    public String getTitle() {
        return this.title;
    }

    public String getPerformer() {
        return this.performer;
    }

    public int getAudioDuration() {
        return this.audio_duration;
    }

    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
    }

    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    @ToString
    public static class InlineQueryResultAudioBuilder {
        private String id = Utils.generateRandomString(32);
        private URL audio_url;
        private String title;
        private String performer;
        private Integer audio_duration;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultAudioBuilder() {
        }

        public InlineQueryResultAudio.InlineQueryResultAudioBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultAudio.InlineQueryResultAudioBuilder audioUrl(URL audioUrl) {
            this.audio_url = audioUrl;
            return this;
        }

        public InlineQueryResultAudio.InlineQueryResultAudioBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultAudio.InlineQueryResultAudioBuilder performer(String performer) {
            this.performer = performer;
            return this;
        }

        public InlineQueryResultAudio.InlineQueryResultAudioBuilder audioDuration(Integer audioDuration) {
            this.audio_duration = audioDuration;
            return this;
        }

        public InlineQueryResultAudio.InlineQueryResultAudioBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        public InlineQueryResultAudio.InlineQueryResultAudioBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultAudio build() {
            return new InlineQueryResultAudio(id, audio_url, title, performer, audio_duration, reply_markup, input_message_content);
        }
    }
}
