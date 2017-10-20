package pro.zackpollard.telegrambot.api.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author Zack Pollard
 */
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRestrictions {

    @Getter
    private final Long untilDate;
    @Getter
    private final Boolean canSendMessages;
    @Getter
    private final Boolean canSendMediaMessages;
    @Getter
    private final Boolean canSendOtherMessages;
    @Getter
    private final Boolean canAddWebPagePreviews;

    public static UserRestrictionsBuilder builder() {
        return new UserRestrictionsBuilder();
    }

    @ToString
    public static class UserRestrictionsBuilder {
        private Long untilDate;
        private Boolean canSendMessages;
        private Boolean canSendMediaMessages;
        private Boolean canSendOtherMessages;
        private Boolean canAddWebPagePreviews;

        UserRestrictionsBuilder() {
        }

        /**
         * *Optional*
         * Date when restrictions will be lifted for the user, unix time. If user is restricted for more than 366 days
         * or less than 30 seconds from the current time, they are considered to be restricted forever
         *
         * @param untilDate Date when restrictions will be lifted for the user, unix time. If user is restricted for
         *                  more than 366 days or less than 30 seconds from the current time, they are considered to be
         *                  restricted forever
         *
         * @return The builder object
         */
        public UserRestrictionsBuilder untilDate(Long untilDate) {
            this.untilDate = untilDate;
            return this;
        }

        /**
         * *Optional*
         * Pass True, if the user can send text messages, contacts, locations and venues
         *
         * @param canSendMessages Pass True, if the user can send text messages, contacts, locations and venues
         *
         * @return The builder object
         */
        public UserRestrictionsBuilder canSendMessages(Boolean canSendMessages) {
            this.canSendMessages = canSendMessages;
            return this;
        }

        /**
         * *Optional*
         * Pass True, if the user can send audios, documents, photos, videos, video notes and voice notes, implies
         * can_send_messages
         *
         * @param canSendMediaMessages Pass True, if the user can send audios, documents, photos, videos, video notes
         *                             and voice notes, implies can_send_messages
         *
         * @return The builder object
         */
        public UserRestrictionsBuilder canSendMediaMessages(Boolean canSendMediaMessages) {
            this.canSendMediaMessages = canSendMediaMessages;
            return this;
        }

        /**
         * *Optional*
         * Pass True, if the user can send animations, games, stickers and use inline bots, implies
         * can_send_media_messages
         *
         * @param canSendOtherMessages Pass True, if the user can send animations, games, stickers and use inline bots,
         *                             implies can_send_media_messages
         *
         * @return The builder object
         */
        public UserRestrictionsBuilder canSendOtherMessages(Boolean canSendOtherMessages) {
            this.canSendOtherMessages = canSendOtherMessages;
            return this;
        }

        /**
         * *Optional*
         * Pass True, if the user may add web page previews to their messages, implies can_send_media_messages
         *
         * @param canAddWebPagePreviews Pass True, if the user may add web page previews to their messages, implies
         *                              can_send_media_messages
         *
         * @return The builder object
         */
        public UserRestrictionsBuilder canAddWebPagePreviews(Boolean canAddWebPagePreviews) {
            this.canAddWebPagePreviews = canAddWebPagePreviews;
            return this;
        }

        /**
         * Builds the UserPromotion object
         *
         * @return A UserPromotion object based on the previously provided values
         */
        public UserRestrictions build() {
            return new UserRestrictions(untilDate, canSendMessages, canSendMediaMessages, canSendOtherMessages, canAddWebPagePreviews);
        }
    }
}