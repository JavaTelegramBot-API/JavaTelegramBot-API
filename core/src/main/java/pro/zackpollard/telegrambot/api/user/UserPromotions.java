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
public class UserPromotions {

    @Getter
    private final Boolean canChangeInfo;
    @Getter
    private final Boolean canPostMessages;
    @Getter
    private final Boolean canEditMessages;
    @Getter
    private final Boolean canDeleteMessages;
    @Getter
    private final Boolean canInviteUsers;
    @Getter
    private final Boolean canRestrictMembers;
    @Getter
    private final Boolean canPinMessages;
    @Getter
    private final Boolean canPromoteMembers;

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A UserPromotionsBuilder object used to construct the UserPromotions object
     */
    public static UserPromotionsBuilder builder() {
        return new UserPromotionsBuilder();
    }

    @ToString
    public static class UserPromotionsBuilder {
        private Boolean canChangeInfo;
        private Boolean canPostMessages;
        private Boolean canEditMessages;
        private Boolean canDeleteMessages;
        private Boolean canInviteUsers;
        private Boolean canRestrictMembers;
        private Boolean canPinMessages;
        private Boolean canPromoteMembers;

        UserPromotionsBuilder() {
        }

        /**
         * *Optional*
         * Pass True, if the administrator can change chat title, photo and other settings
         *
         * @param canChangeInfo Pass True, if the administrator can change chat title, photo and other settings
         *
         * @return The builder object
         */
        public UserPromotionsBuilder canChangeInfo(Boolean canChangeInfo) {
            this.canChangeInfo = canChangeInfo;
            return this;
        }

        /**
         * *Optional*
         * Pass True, if the administrator can create channel posts, channels only
         *
         * @param canPostMessages Pass True, if the administrator can create channel posts, channels only
         *
         * @return The builder object
         */
        public UserPromotionsBuilder canPostMessages(Boolean canPostMessages) {
            this.canPostMessages = canPostMessages;
            return this;
        }

        /**
         * *Optional*
         * Pass True, if the administrator can edit messages of other users, channels only
         *
         * @param canEditMessages Pass True, if the administrator can edit messages of other users, channels only
         *
         * @return The builder object
         */
        public UserPromotionsBuilder canEditMessages(Boolean canEditMessages) {
            this.canEditMessages = canEditMessages;
            return this;
        }

        /**
         * *Optional*
         * Pass True, if the administrator can delete messages of other users
         *
         * @param canDeleteMessages Pass True, if the administrator can delete messages of other users
         *
         * @return The builder object
         */
        public UserPromotionsBuilder canDeleteMessages(Boolean canDeleteMessages) {
            this.canDeleteMessages = canDeleteMessages;
            return this;
        }

        /**
         * *Optional*
         * Pass True, if the administrator can invite new users to the chat
         *
         * @param canInviteUsers Pass True, if the administrator can invite new users to the chat
         *
         * @return The builder object
         */
        public UserPromotionsBuilder canInviteUsers(Boolean canInviteUsers) {
            this.canInviteUsers = canInviteUsers;
            return this;
        }

        /**
         * Pass True, if the administrator can restrict, ban or unban chat members
         *
         * @param canRestrictMembers Pass True, if the administrator can restrict, ban or unban chat members
         *
         * @return The builder object
         */
        public UserPromotionsBuilder canRestrictMembers(Boolean canRestrictMembers) {
            this.canRestrictMembers = canRestrictMembers;
            return this;
        }

        /**
         * *Optional*
         * Pass True, if the administrator can pin messages, supergroups only
         *
         * @param canPinMessages Pass True, if the administrator can pin messages, supergroups only
         *
         * @return The builder object
         */
        public UserPromotionsBuilder canPinMessages(Boolean canPinMessages) {
            this.canPinMessages = canPinMessages;
            return this;
        }

        /**
         * *Optional*
         * 	Pass True, if the administrator can add new administrators with a subset of his own privileges or demote
         * 	administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed
         * 	by them)
         *
         * @param canPromoteMembers Pass True, if the administrator can add new administrators with a subset of his
         *                          own privileges or demote administrators that he has promoted, directly or indirectly
         *                          (promoted by administrators that were appointed by him)
         *
         * @return The builder object
         */
        public UserPromotionsBuilder canPromoteMembers(Boolean canPromoteMembers) {
            this.canPromoteMembers = canPromoteMembers;
            return this;
        }

        /**
         * Builds the UserPromotion object
         *
         * @return A UserPromotion object based on the previously provided values
         */
        public UserPromotions build() {
            return new UserPromotions(canChangeInfo, canPostMessages, canEditMessages, canDeleteMessages, canInviteUsers, canRestrictMembers, canPinMessages, canPromoteMembers);
        }
    }
}