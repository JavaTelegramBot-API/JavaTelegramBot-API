package pro.zackpollard.telegrambot.api.chat.message;

import lombok.ToString;

/**
 * @author Zack Pollard
 */

@ToString
public class ForceReply implements ReplyMarkup {

    private final boolean force_reply = true;
    private boolean selective = false;

    private ForceReply(ForceReplyBuilder builder) {

        this.selective = builder.selective;
    }

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A ForceReplyBuilder object used to construct the ForceReply object
     */
    public static ForceReplyBuilder builder() {

        return new ForceReplyBuilder();
    }

    /**
     * Gets whether the ForceReply is selective
     *
     * @return True if the ForceReply is selective, otherwise False
     */
    public boolean getSelective() {

        return selective;
    }

    /**
     * Gets the ReplyMarkupType for this ReplyMarkup object
     *
     * @return The ReplyMarkupType for this ReplyMarkup object
     */
    @Override
    public ReplyMarkupType getType() {
        return ReplyMarkupType.FORCE_REPLY;
    }

    @ToString
    public static class ForceReplyBuilder {

        private boolean selective = false;

        private ForceReplyBuilder() {
        }

        /**
         * *Optional*
         * Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned
         * in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of
         * the original message.
         *
         * @param selective True makes the ForceReply selective, False keeps it as non-selective
         *
         * @return The builder object
         */
        public ForceReplyBuilder selective(boolean selective) {

            this.selective = selective;
            return this;
        }

        /**
         * Builds the ForceReply object
         *
         * @return A ForceReply object based on the previously provided values
         */
        public ForceReply build() {

            return new ForceReply(this);
        }
    }
}