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
    private final String caption;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultCachedAudioBuilder object used to construct the InlineQueryResultCachedAudio object
     */
    public static InlineQueryResultCachedAudioBuilder builder() {
        return new InlineQueryResultCachedAudioBuilder();
    }

    /**
     * Get the type of InlineQueryResult that this object refers to
     *
     * @return The InlineQueryResultType for this object
     */
    @Override
    public InlineQueryResultType getType() {
        return this.type;
    }

    /**
     * Gets the ID of this InlineQueryResult object
     *
     * @return The ID of this result
     */
    @NonNull
    public String getId() {
        return this.id;
    }

    /**
     * Gets the ID for the cached audio file on the telegram servers
     *
     * @return The ID for the cached audio file on the telegram servers
     */
    @NonNull
    private String getAudioFileId() {
        return this.audio_file_id;
    }

    /**
     * Gets the inline keyboard attached to this message
     *
     * @return The inline keyboard attached to this message
     */
    public InlineReplyMarkup getReplyMarkup() {
        return this.reply_markup;
    }

    /**
     * Gets the content of the message to be sent instead of the audio
     *
     * @return The content of the message to be sent instead of the audio
     */
    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    /**
     * Gets the caption of the result
     *
     * @return The caption of the result
     */
    public String getCaption() {
        return this.caption;
    }

    @ToString
    public static class InlineQueryResultCachedAudioBuilder {
        private String id = Utils.generateRandomString(32);
        private String audio_file_id;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;
        private String caption;

        InlineQueryResultCachedAudioBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultCachedAudioBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the ID of the cached audio file on the telegram servers that you want this result to use
         *
         * @param audioFileId The ID of the cached audio file you want to use from the telegram servers
         *
         * @return The builder object
         */
        public InlineQueryResultCachedAudioBuilder audioFileId(String audioFileId) {
            this.audio_file_id = audioFileId;
            return this;
        }

        /**
         * *Optional*
         * Sets the inline keyboard attached to this message to the InlineReplyMarkup provided
         *
         * @param replyMarkup The inline keyboard you want to attach to the message
         *
         * @return The builder object
         */
        public InlineQueryResultCachedAudioBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        /**
         * *Optional*
         * Sets the content you want to be sent with this result to the provided InputMessageContent object
         *
         * @param inputMessageContent The content you want to be sent with the result
         *
         * @return The builder object
         */
        public InlineQueryResultCachedAudioBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * *Optional*
         * Sets the caption you wat to be sent with this result to the provided String
         *
         * @param caption The caption you want to be sent with the result
         *
         * @return The builder object
         */
        public InlineQueryResultCachedAudio.InlineQueryResultCachedAudioBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        /**
         * Builds the InlineQueryResultCachedAudio object
         *
         * @return An InlineQueryResultCachedAudio object based on the previously provided values
         */
        public InlineQueryResultCachedAudio build() {
            return new InlineQueryResultCachedAudio(id, audio_file_id, reply_markup, input_message_content, caption);
        }
    }
}
