package pro.zackpollard.telegrambot.api.keyboards;

import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkupType;

/**
 * @author Zack Pollard
 */
@ToString
public class ReplyKeyboardHide implements Keyboard {

    private final boolean hide_keyboard = true;
    private boolean selective = false;

    private ReplyKeyboardHide(ReplyKeyboardHideBuilder builder) {

        this.selective = builder.selective;
    }

    public static ReplyKeyboardHideBuilder builder() {

        return new ReplyKeyboardHideBuilder();
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
    public boolean getSelective() {
        return selective;
    }

    @Override
    public ReplyMarkupType getType() {
        return ReplyMarkupType.KEYBOARD_HIDE;
    }

    @ToString
    public static class ReplyKeyboardHideBuilder {

        private boolean selective = false;

        private ReplyKeyboardHideBuilder() {
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