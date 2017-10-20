package pro.zackpollard.telegrambot.api.keyboards;

import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkupType;

/**
 * @author Zack Pollard
 */
@ToString
public class ReplyKeyboardRemove implements Keyboard {

    private final boolean hide_keyboard = true;
    private boolean selective = false;

    private ReplyKeyboardRemove(ReplyKeyboardRemoveBuilder builder) {

        this.selective = builder.selective;
    }

    /**
     * This builder will allow you to progressively construct this object.
     *
     * @return A ReplyKeyboardRemoveBuilder object used to construct the ReplyKeyboardRemove object
     */
    public static ReplyKeyboardRemoveBuilder builder() {

        return new ReplyKeyboardRemoveBuilder();
    }

    /**
     * Gets whether the client is being requested to hide the custom keyboard
     *
     * @return True if the client is being requested to hide the custom keyboard, otherwise False
     */
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

    /**
     * Gets the ReplyMarkupType for this ReplyMarkup object
     *
     * @return The ReplyMarkupType for this ReplyMarkup object
     */
    @Override
    public ReplyMarkupType getType() {
        return ReplyMarkupType.KEYBOARD_REMOVE;
    }

    @ToString
    public static class ReplyKeyboardRemoveBuilder {

        private boolean selective = false;

        private ReplyKeyboardRemoveBuilder() {
        }

        /**
         * *Optional*
         * Sets whether the keyboard should be selective. Use this parameter if you want to hide keyboard for specific
         * users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message
         * is a reply (has reply_to_message_id), sender of the original message.
         *
         * @param selective True if the keyboard is selective, otherwise False
         *
         * @return The builder object
         */
        public ReplyKeyboardRemoveBuilder selective(boolean selective) {

            this.selective = selective;
            return this;
        }

        /**
         * Builds the ReplyKeyboardRemove object
         *
         * @return A ReplyKeyboardRemove object based on the previously provided values
         */
        public ReplyKeyboardRemove build() {

            return new ReplyKeyboardRemove(this);
        }
    }
}