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

    public boolean getSelective() {

        return selective;
    }

    @Override
    public ReplyMarkupType getType() {
        return ReplyMarkupType.FORCE_REPLY;
    }

    @ToString
    public static class ForceReplyBuilder {

        private boolean selective = false;

        private ForceReplyBuilder() {
        }

        public ForceReplyBuilder selective(boolean selective) {

            this.selective = selective;
            return this;
        }

        public ForceReply build() {

            return new ForceReply(this);
        }
    }
}