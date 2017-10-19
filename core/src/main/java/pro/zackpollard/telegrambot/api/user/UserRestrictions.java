package pro.zackpollard.telegrambot.api.chat.edit;

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

    public static class UserRestrictionsBuilder {
        private Long untilDate;
        private Boolean canSendMessages;
        private Boolean canSendMediaMessages;
        private Boolean canSendOtherMessages;
        private Boolean canAddWebPagePreviews;

        UserRestrictionsBuilder() {
        }

        public UserRestrictionsBuilder untilDate(Long untilDate) {
            this.untilDate = untilDate;
            return this;
        }

        public UserRestrictionsBuilder canSendMessages(Boolean canSendMessages) {
            this.canSendMessages = canSendMessages;
            return this;
        }

        public UserRestrictionsBuilder canSendMediaMessages(Boolean canSendMediaMessages) {
            this.canSendMediaMessages = canSendMediaMessages;
            return this;
        }

        public UserRestrictionsBuilder canSendOtherMessages(Boolean canSendOtherMessages) {
            this.canSendOtherMessages = canSendOtherMessages;
            return this;
        }

        public UserRestrictionsBuilder canAddWebPagePreviews(Boolean canAddWebPagePreviews) {
            this.canAddWebPagePreviews = canAddWebPagePreviews;
            return this;
        }

        public UserRestrictions build() {
            return new UserRestrictions(untilDate, canSendMessages, canSendMediaMessages, canSendOtherMessages, canAddWebPagePreviews);
        }

        public String toString() {
            return "UserRestrictions.UserRestrictionsBuilder(untilDate=" + this.untilDate + ", canSendMessages=" + this.canSendMessages + ", canSendMediaMessages=" + this.canSendMediaMessages + ", canSendOtherMessages=" + this.canSendOtherMessages + ", canAddWebPagePreviews=" + this.canAddWebPagePreviews + ")";
        }
    }
}