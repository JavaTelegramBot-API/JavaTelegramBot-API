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

    @Override
    public InlineQueryResultType getType() {
        return this.type;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @NonNull
    public String getPhoneNumber() {
        return this.phone_number;
    }

    @NonNull
    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
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

        public InlineQueryResultContact.InlineQueryResultContactBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InlineQueryResultContact.InlineQueryResultContactBuilder phoneNumber(String phoneNumber) {
            this.phone_number = phoneNumber;
            return this;
        }

        public InlineQueryResultContact.InlineQueryResultContactBuilder firstName(String firstName) {
            this.first_name = firstName;
            return this;
        }

        public InlineQueryResultContact.InlineQueryResultContactBuilder lastName(String lastName) {
            this.last_name = lastName;
            return this;
        }

        public InlineQueryResultContact.InlineQueryResultContactBuilder replyMarkup(InlineReplyMarkup replyMarkup) {
            this.reply_markup = replyMarkup;
            return this;
        }

        public InlineQueryResultContact.InlineQueryResultContactBuilder inputMessageContent(InputMessageContent inputMessageContent) {
            this.input_message_content = inputMessageContent;
            return this;
        }

        public InlineQueryResultContact.InlineQueryResultContactBuilder thumbUrl(URL thumbUrl) {
            this.thumb_url = thumbUrl;
            return this;
        }

        public InlineQueryResultContact.InlineQueryResultContactBuilder thumbWidth(Integer thumbWidth) {
            this.thumb_width = thumbWidth;
            return this;
        }

        public InlineQueryResultContact.InlineQueryResultContactBuilder thumbHeight(Integer thumbHeight) {
            this.thumb_height = thumbHeight;
            return this;
        }

        public InlineQueryResultContact build() {
            return new InlineQueryResultContact(id, phone_number, first_name, last_name, reply_markup, input_message_content, thumb_url, thumb_width, thumb_height);
        }
    }
}
