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
    private final String caption;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultAudioBuilder object used to construct the InlineQueryResultAudio object
     */
    public static InlineQueryResultAudioBuilder builder() {
        return new InlineQueryResultAudioBuilder();
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
     * Gets the URL for the audio
     *
     * @return The URL for the audio
     */
    @NonNull
    public URL getAudioUrl() {
        return this.audio_url;
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
     * Gets the caption of the result
     *
     * @return The caption of the result
     */
    public String getCaption() {
        return this.caption;
    }

    /**
     * Gets the performer of the audio
     *
     * @return The performer of the audio
     */
    public String getPerformer() {
        return this.performer;
    }

    /**
     * Gets the duration of the audio
     *
     * @return The duration of the audio
     */
    public int getAudioDuration() {
        return this.audio_duration;
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

    @ToString
    public static class InlineQueryResultAudioBuilder {
        private String id = Utils.generateRandomString(32);
        private URL audio_url;
        private String title;
        private String performer;
        private Integer audio_duration;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;
        private String caption;

        InlineQueryResultAudioBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultAudio.InlineQueryResultAudioBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the URL of the audio for the result
         *
         * @param audioUrl The URL of the audio for the result
         *
         * @return The builder object
         */
        public InlineQueryResultAudio.InlineQueryResultAudioBuilder audioUrl(URL audioUrl) {
            this.audio_url = audioUrl;
            return this;
        }

        /**
         * *Optional*
         * Sets the title to the provided value
         *
         * @param title The title you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultAudio.InlineQueryResultAudioBuilder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * *Optional*
         * Sets the performer to the provided value
         *
         * @param performer The performer of the audio file
         *
         * @return The builder object
         */
        public InlineQueryResultAudio.InlineQueryResultAudioBuilder performer(String performer) {
            this.performer = performer;
            return this;
        }

        /**
         * *Optional*
         * Sets the duration of the audio to the provided value
         *
         * @param audioDuration The duration of the audio file
         *
         * @return The builder object
         */
        public InlineQueryResultAudio.InlineQueryResultAudioBuilder audioDuration(Integer audioDuration) {
            this.audio_duration = audioDuration;
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
        public InlineQueryResultAudio.InlineQueryResultAudioBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
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
        public InlineQueryResultAudio.InlineQueryResultAudioBuilder inputMessageContent(InputMessageContent inputMessageContent) {
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
        public InlineQueryResultAudio.InlineQueryResultAudioBuilder caption(String caption) {
            this.caption = caption;
            return this;
        }

        /**
         * Builds the InlineQueryResultAudio object
         *
         * @return An InlineQueryResultAudio object based on the previously provided values
         */
        public InlineQueryResultAudio build() {
            return new InlineQueryResultAudio(id, audio_url, title, performer, audio_duration, reply_markup, input_message_content, caption);
        }
    }
}