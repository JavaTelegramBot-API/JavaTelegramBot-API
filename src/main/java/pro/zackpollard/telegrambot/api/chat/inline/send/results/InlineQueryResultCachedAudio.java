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
public class InlineQueryResultCachedAudio implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.AUDIO;
    @NonNull
    private final String id;
    @NonNull
    private final String audio_file_id;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;

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
    private String getAudioFileId() {
        return this.audio_file_id;
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
        private String audio_file_id;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;

        InlineQueryResultAudioBuilder() {
        }

        public InlineQueryResultCachedAudio.InlineQueryResultAudioBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultCachedAudio.InlineQueryResultAudioBuilder audioFileId(String audioFileId) {
            this.audio_file_id = audioFileId;
            return this;
        }

        public InlineQueryResultCachedAudio.InlineQueryResultAudioBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        public InlineQueryResultCachedAudio.InlineQueryResultAudioBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultCachedAudio build() {
            return new InlineQueryResultCachedAudio(id, audio_file_id, reply_markup, input_message_content);
        }
    }
}
