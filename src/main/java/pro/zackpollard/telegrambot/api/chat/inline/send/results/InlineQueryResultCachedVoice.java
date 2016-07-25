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
public class InlineQueryResultCachedVoice implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.VOICE;
    @NonNull
    private final String id;
    @NonNull
    private final String voice_file_id;
    @NonNull
    private final String title;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultCachedVoiceBuilder object used to construct the InlineQueryResultCachedVoice object
     */
    public static InlineQueryResultCachedVoiceBuilder builder() {
        return new InlineQueryResultCachedVoiceBuilder();
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
    public String getVoiceFileId() {
        return this.voice_file_id;
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

    @ToString
    public static class InlineQueryResultCachedVoiceBuilder {
        private String id = Utils.generateRandomString(32);
        private String voice_file_id;
        private String title;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultCachedVoiceBuilder() {
        }

        public InlineQueryResultCachedVoiceBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultCachedVoiceBuilder voiceFileId(String voiceFileId) {
            this.voice_file_id = voiceFileId;
            return this;
        }

        public InlineQueryResultCachedVoiceBuilder title(String title) {
            this.title = title;
            return this;
        }

        public InlineQueryResultCachedVoiceBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        public InlineQueryResultCachedVoiceBuilder input_message_content(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultCachedVoice build() {
            return new InlineQueryResultCachedVoice(id, voice_file_id, title, reply_markup, input_message_content);
        }
    }
}
