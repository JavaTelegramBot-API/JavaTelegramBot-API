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
     * Gets the ID for the cached voice file on the telegram servers
     *
     * @return The ID for the cached voice file on the telegram servers
     */
    @NonNull
    public String getVoiceFileId() {
        return this.voice_file_id;
    }

    /**
     * Gets the title of the result
     *
     * @return The title of the result
     */
    @NonNull
    public String getTitle() {
        return this.title;
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
     * Gets the content of the message to be sent instead of the voice recording
     *
     * @return The content of the message to be sent instead of the recording
     */
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

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultCachedVoiceBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the ID of the cached voice file on the telegram servers that you want this result to use
         *
         * @param voiceFileId The ID of the cached voice file you want to use from the telegram servers
         *
         * @return The builder object
         */
        public InlineQueryResultCachedVoiceBuilder voiceFileId(String voiceFileId) {
            this.voice_file_id = voiceFileId;
            return this;
        }

        /**
         * *Required*
         * Sets the title to the provided value
         *
         * @param title The title you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultCachedVoiceBuilder title(String title) {
            this.title = title;
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
        public InlineQueryResultCachedVoiceBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
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
        public InlineQueryResultCachedVoiceBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * Builds the InlineQueryResultCachedVoice object
         *
         * @return An InlineQueryResultCachedVoice object based on the previously provided values
         */
        public InlineQueryResultCachedVoice build() {
            return new InlineQueryResultCachedVoice(id, voice_file_id, title, reply_markup, input_message_content);
        }
    }
}
