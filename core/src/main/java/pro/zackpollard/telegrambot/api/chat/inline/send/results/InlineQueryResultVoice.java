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
    private final String caption;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultVoiceBuilder object used to construct the InlineQueryResultVoice object
     */
    public static InlineQueryResultVoiceBuilder builder() {
        return new InlineQueryResultVoiceBuilder();
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
     * Gets the URL of the voice recording
     *
     * @return The URL of the voice recording
     */
    @NonNull
    public URL getVoiceUrl() {
        return this.voice_url;
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
     * Gets the duration of the voice recording
     *
     * @return The duration of the voice recording
     */
    public Integer getVoiceDuration() {
        return this.voice_duration;
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
     * @return The content of the message to be sent instead of the voice recording
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
    public static class InlineQueryResultVoiceBuilder {
        private String id = Utils.generateRandomString(32);
        private URL voice_url;
        private String title;
        private Integer voice_duration;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;
        private String caption;

        InlineQueryResultVoiceBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the URL of the voice recording for the result
         *
         * @param voiceUrl The URL of the voice recording for the result
         *
         * @return The builder object
         */
        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder voiceUrl(URL voiceUrl) {
            this.voice_url = voiceUrl;
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
        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * *Optional*
         * Sets the duration of the voice recording file being sent for this result
         *
         * @param voiceDuration The duration of the voice recording file
         *
         * @return The builder object
         */
        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder voiceDuration(Integer voiceDuration) {
            this.voice_duration = voiceDuration;
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
        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
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
        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder inputMessageContent(InputMessageContent inputMessageContent) {
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
        public InlineQueryResultVoice.InlineQueryResultVoiceBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        /**
         * Builds the InlineQueryResultVoice object
         *
         * @return An InlineQueryResultVoice object based on the previously provided values
         */
        public InlineQueryResultVoice build() {
            return new InlineQueryResultVoice(id, voice_url, title, voice_duration, reply_markup, input_message_content, caption);
        }
    }
}
