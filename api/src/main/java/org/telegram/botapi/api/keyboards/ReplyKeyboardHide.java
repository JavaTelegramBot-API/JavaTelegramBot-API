package org.telegram.botapi.api.keyboards;

/**
 * @author Zack Pollard
 */
public class ReplyKeyboardHide implements Keyboard {

    private final boolean hide_keyboard = true;
	private boolean selective = false;

	private ReplyKeyboardHide(ReplyKeyboardHideBuilder builder) {

		this.selective = builder.selective;
	}

	public ReplyKeyboardHide() {
	}

	public ReplyKeyboardHide(boolean selective) {

		this.selective = selective;
	}

	public static ReplyKeyboardHide builder() {

		return new ReplyKeyboardHide();
	}

    public boolean getHideKeyboard() {

        return hide_keyboard;
    }

	/**
	 * Gets whether the reply markup will only show for selected users
	 * Targets: 1) users that are @mentioned in the text of the Message object;
	 * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
	 *
	 * @return Selective option, default false
	 */
	@Override
	public boolean getSelective() {
		return false;
	}

	@Override
	public void setSelective(boolean selective) {

		this.selective = selective;
	}

	public static class ReplyKeyboardHideBuilder {

		private boolean selective = false;

		public ReplyKeyboardHideBuilder() {
		}

		public ReplyKeyboardHideBuilder selective(boolean selective) {

			this.selective = selective;
			return this;
		}

		public ReplyKeyboardHide build() {

			return new ReplyKeyboardHide(this);
		}
	}
}