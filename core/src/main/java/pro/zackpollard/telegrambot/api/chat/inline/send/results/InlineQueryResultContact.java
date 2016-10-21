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
public class InlineQueryResultContact implements InlineQueryResult {

    private final InlineQueryResultType type = InlineQueryResultType.CONTACT;
    @NonNull
    private final String id;
    @NonNull
    private final String phone_number;
    @NonNull
    private final String first_name;
    private final String last_name;
    private final InlineReplyMarkup reply_markup;
    private final InputMessageContent input_message_content;
    private final URL thumb_url;
    private final Integer thumb_width;
    private final Integer thumb_height;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return An InlineQueryResultContactBuilder object used to construct the InlineQueryResultContact object
     */
    public static InlineQueryResultContactBuilder builder() {
        return new InlineQueryResultContactBuilder();
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
     * Gets the phone number of the contact
     *
     * @return The phone number of the contact
     */
    @NonNull
    public String getPhoneNumber() {
        return this.phone_number;
    }

    /**
     * Gets the first name of the contact
     *
     * @return The first name of the contact
     */
    @NonNull
    public String getFirstName() {
        return this.first_name;
    }

    /**
     * Gets the last name of the contact
     *
     * @return The last name of the contact
     */
    public String getLastName() {
        return this.last_name;
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
     * Gets the content of the message to be sent instead of the contact
     *
     * @return The content of the message to be sent instead of the contact
     */
    public InputMessageContent getInputMessageContent() {
        return this.input_message_content;
    }

    /**
     * Gets the URL of the thumbnail for the result
     *
     * @return The URL of the thumbnail for the result
     */
    public URL getThumbUrl() {
        return this.thumb_url;
    }

    /**
     * Gets the width of the thumbnail in pixels
     *
     * @return The width of the thumbnail in pixels
     */
    public int getThumbWidth() {
        return this.thumb_width;
    }

    /**
     * Gets the height of the thumbnail in pixels
     *
     * @return The height of the thumbnail in pixels
     */
    public int getThumbHeight() {
        return this.thumb_height;
    }

    @ToString
    public static class InlineQueryResultContactBuilder {
        private String id = Utils.generateRandomString(32);
        private String phone_number;
        private String first_name;
        private String last_name;
        private InlineReplyMarkup reply_markup;
        private InputMessageContent input_message_content;
        private URL thumb_url;
        private Integer thumb_width;
        private Integer thumb_height;

        InlineQueryResultContactBuilder() {
        }

        /**
         * *Optional*
         * Sets the ID to the provided value. If none is set a random 32 char long ID will be generated.
         *
         * @param id The ID you want the result to have
         *
         * @return The builder object
         */
        public InlineQueryResultContact.InlineQueryResultContactBuilder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * *Required*
         * Sets the phone number of the contact to the provided value
         *
         * @param phoneNumber The phone number of the contact
         *
         * @return The builder object
         */
        public InlineQueryResultContact.InlineQueryResultContactBuilder phoneNumber(String phoneNumber) {
            this.phone_number = phoneNumber;
            return this;
        }

        /**
         * *Required*
         * Sets the first name of the contact to the provided value
         *
         * @param firstName The first name of the contact
         *
         * @return The builder object
         */
        public InlineQueryResultContact.InlineQueryResultContactBuilder firstName(String firstName) {
            this.first_name = firstName;
            return this;
        }

        /**
         * *Optional*
         * Sets the last name of the contact to the provided value
         *
         * @param lastName The last name of the contact
         *
         * @return The builder object
         */
        public InlineQueryResultContact.InlineQueryResultContactBuilder lastName(String lastName) {
            this.last_name = lastName;
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
        public InlineQueryResultContact.InlineQueryResultContactBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
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
        public InlineQueryResultContact.InlineQueryResultContactBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        /**
         * *Optional*
         * Sets the URL of the thumbnail that should show next to the result in the inline result selection pane
         *
         * @param thumbUrl The URL of the thumbnail you want to be shown next to the result in the result selection pane
         *
         * @return The builder object
         */
        public InlineQueryResultContact.InlineQueryResultContactBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        /**
         * *Optional*
         * Sets the width of the thumbnail at the previously provided URL through {@link #thumbUrl(URL)}
         *
         * @param thumbWidth The width of the thumbnail
         *
         * @return The builder object
         */
        public InlineQueryResultContact.InlineQueryResultContactBuilder thumbWidth(int thumbWidth) {
            this.thumb_width = thumbWidth;
            return this;
        }

        /**
         * *Optional*
         * Sets the height of the thumbnail at the previously provided URL through {@link #thumbUrl(URL)}
         *
         * @param thumbHeight The height of the thumbnail
         *
         * @return The builder object
         */
        public InlineQueryResultContact.InlineQueryResultContactBuilder thumbHeight(int thumbHeight) {
            this.thumb_height = thumbHeight;
            return this;
        }

        /**
         * Builds the InlineQueryResultContact object
         *
         * @return An InlineQueryResultContact object based on the previously provided values
         */
        public InlineQueryResultContact build() {
            return new InlineQueryResultContact(id, phone_number, first_name, last_name, reply_markup, input_message_content, thumb_url, thumb_width, thumb_height);
        }
    }
}
