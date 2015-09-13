package org.telegram.botapi.api.chat.message;

/**
 * @author Zack Pollard
 */

public class ForceReply implements ReplyMarkup {

	private final boolean force_reply = true;
	private boolean selective = false;

	private ForceReply(ForceReplyBuilder builder) {

		this.selective = builder.selective;
	}

	public ForceReply() {
	}

	public ForceReply(boolean selective) {

		this.selective = selective;
	}

	public static ForceReplyBuilder builder() {

		return new ForceReplyBuilder();
	}

	public boolean getSelective() {

		return selective;
	}

	@Override
	public void setSelective(boolean selective) {

		this.selective = selective;
	}

	@Override
	public ReplyMarkupType getType() {
		return ReplyMarkupType.FORCE_REPLY;
	}

	public static class ForceReplyBuilder {

		private boolean selective = false;

		public ForceReplyBuilder() {
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