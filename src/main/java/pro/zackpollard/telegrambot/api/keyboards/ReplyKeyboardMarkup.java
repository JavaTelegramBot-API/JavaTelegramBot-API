package pro.zackpollard.telegrambot.api.keyboards;

import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkupType;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class ReplyKeyboardMarkup implements Keyboard {

	private final List<List<String>> keyboard;
	private final boolean resize_keyboard;
	private final boolean one_time_keyboard;
	private boolean selective;

	private ReplyKeyboardMarkup(ReplyKeyboardMarkupBuilder builder) {

		this.keyboard = builder.keyboard;
		this.resize_keyboard = builder.resize_keyboard;
		this.one_time_keyboard = builder.one_time_keyboard;
		this.selective = builder.selective;
	}

	public ReplyKeyboardMarkup(List<List<String>> keyboard, boolean resize_keyboard, boolean one_time_keyboard, boolean selective) {

		this.keyboard = keyboard;
		this.resize_keyboard = resize_keyboard;
		this.one_time_keyboard = one_time_keyboard;
		this.selective = selective;
	}

	public static ReplyKeyboardMarkupBuilder builder() {

		return new ReplyKeyboardMarkupBuilder();
	}

	/**
	 * Gets Array of button rows, each represented by an Array of Strings
	 *
	 * @return Button rows
	 */
	public List<List<String>> getButtons() {

		return keyboard;
	}

	/**
	 * Gets whether the keyboard should be resized on the client for optimal vertical fit
	 *
	 * @return Resize option, default false
	 */
	public boolean getResize_keyboard() {

		return resize_keyboard;
	}

	/**
	 * Gets whether the keyboard is one-time i.e. will vanish after it has been used
	 *
	 * @return One-time option, default false
	 */
	public boolean getOneTime() {

		return one_time_keyboard;
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
		return selective;
	}

	@Override
	public void setSelective(boolean selective) {

	}

	@Override
	public ReplyMarkupType getType() {
		return ReplyMarkupType.KEYBOARD_MARKUP;
	}

	public static class ReplyKeyboardMarkupBuilder {

		private final List<List<String>> keyboard = new LinkedList<>();
		private boolean resize_keyboard = false;
		private boolean one_time_keyboard = false;
		private boolean selective = false;

		private ReplyKeyboardMarkupBuilder() {
		}

		/**
		 * Add a new row to the keyboard
		 *
		 * @param cellValues The values for the new row
		 * @return The keyboard builder
		 */
		public ReplyKeyboardMarkupBuilder addRow(String... cellValues) {

			List<String> list = new LinkedList<>();

			Collections.addAll(list, cellValues);
			return addRow(list);
		}

		/**
		 * Add a new row to the keyboard
		 *
		 * @param cellValues The values for the new row
		 * @return The keyboard builder
		 */
		public ReplyKeyboardMarkupBuilder addRow(List<String> cellValues) {

			keyboard.add(cellValues);
			return this;
		}

		/**
		 * Sets a row of the keyboard
		 *
		 * @param cellValues The values for the row
		 * @return The keyboard builder
		 * @throws IndexOutOfBoundsException if the row is out of range
		 */
		public ReplyKeyboardMarkupBuilder setRow(int row, String... cellValues) {

			List<String> list = new LinkedList<>();

			Collections.addAll(list, cellValues);
			return setRow(row, list);
		}

		/**
		 * Sets a row of the keyboard
		 *
		 * @param row        The index of the row
		 * @param cellValues The values for the row
		 * @return The keyboard builder
		 * @throws IndexOutOfBoundsException if the row is out of range
		 */
		public ReplyKeyboardMarkupBuilder setRow(int row, List<String> cellValues) {

			keyboard.get(row).clear();
			keyboard.get(row).addAll(cellValues);
			return this;
		}

		/**
		 * Sets a cell of the keyboard
		 *
		 * @param row       The index of the row
		 * @param column    The index of the column
		 * @param cellValue The value for the cell
		 * @return The keyboard builder
		 * @throws IndexOutOfBoundsException if the row or column is out of range
		 */
		public ReplyKeyboardMarkupBuilder setCell(int row, int column, String cellValue) {

			keyboard.get(row).set(column, cellValue);
			return this;
		}

		/**
		 * Optional. Requests clients to resize the keyboard vertically for optimal fit
		 * (e.g., make the keyboard smaller if there are just two rows of buttons).
		 * Defaults to false, in which case the custom keyboard is always of the
		 * same height as the app's standard keyboard.
		 *
		 * @param resize Whether the client should resize the keyboard.
		 * @return The keyboard builder.
		 */
		public ReplyKeyboardMarkupBuilder resize(boolean resize) {

			this.resize_keyboard = resize;
			return this;
		}

		/**
		 * Optional. Requests clients to hide the keyboard as soon as it's been used.
		 * Defaults to false.
		 *
		 * @param oneTime Whether the keyboard is a one time keyboard.
		 * @return
		 */
		public ReplyKeyboardMarkupBuilder oneTime(boolean oneTime) {

			this.one_time_keyboard = oneTime;
			return this;
		}

		public ReplyKeyboardMarkupBuilder selective(boolean selective) {

			this.selective = selective;
			return this;
		}

		public ReplyKeyboardMarkup build() {

			return new ReplyKeyboardMarkup(this);
		}
	}
}
