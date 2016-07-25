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
public class InlineQueryResultVoice implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.VOICE;
    @NonNull
    private final String id;
    @NonNull
    private final URL voice_url;
    @NonNull
    private final String title;
    private final Integer voice_duration;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    public static InlineQueryResultVoiceBuilder builder() {
        return new InlineQueryResultVoiceBuilder();
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
    public URL getVoiceUrl() {
        return this.voice_url;
    }

    @NonNull
    public String getTitle() {
        return this.title;
    }

    public Integer getVoiceDuration() {
        return this.voice_duration;
    }

    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
    }

    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    @ToString
    public static class InlineQueryResultVoiceBuilder {
        private String id = Utils.generateRandomString(32);
        private URL voice_url;
        private String title;
        private Integer voice_duration;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultVoiceBuilder() {
        }

        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder voiceUrl(URL voiceUrl) {
            this.voice_url = voiceUrl;
            return this;
        }

        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder voiceDuration(Integer voiceDuration) {
            this.voice_duration = voiceDuration;
            return this;
        }

        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultVoice build() {
            return new InlineQueryResultVoice(id, voice_url, title, voice_duration, reply_markup, input_message_content);
        }
    }
}
