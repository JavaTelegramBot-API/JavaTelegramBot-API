package pro.zackpollard.telegrambot.api.keyboards;

import lombok.ToString;
import pro.zackpollard.telegrambot.api.chat.message.ReplyMarkupType;

/**
 * @author Zack Pollard
 */
@ToString
@Deprecated
/**
 * This has been replaced with ReplyKeyboardRemove. If you wish to only hide the keyboard, you should use
 * one_time_keyboard from the keyboard markup itself upon creation.
 */
public class ReplyKeyboardHide implements Keyboard {

    private final boolean hide_keyboard = true;
    private boolean selective = false;

    private ReplyKeyboardHide(ReplyKeyboardHideBuilder builder) {

        this.selective = builder.selective;
    }

    /**
     * This builder will allow you to progressively construct this object.
     *
     * This has been replaced with ReplyKeyboardRemove. If you wish to only hide the keyboard, you should use
     * one_time_keyboard from the keyboard markup itself upon creation.
     *
     * @return A ReplyKeyboardHideBuilder object used to construct the ReplyKeyboardHide object
     */
    @Deprecated
    public static ReplyKeyboardHideBuilder builder() {

        return new ReplyKeyboardHideBuilder();
    }

    /**
     * Gets whether the client is being requested to hide the custom keyboard
     *
     * This has been replaced with ReplyKeyboardRemove. If you wish to only hide the keyboard, you should use
     * one_time_keyboard from the keyboard markup itself upon creation.
     *
     * @return True if the client is being requested to hide the custom keyboard, otherwise False
     */
    @Deprecated
    public boolean getHideKeyboard() {

        return hide_keyboard;
    }

    /**
     * Gets whether the reply markup will only show for selected users
     * Targets: 1) users that are @mentioned in the text of the Message object;
     * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     *
     * This has been replaced with ReplyKeyboardRemove. If you wish to only hide the keyboard, you should use
     * one_time_keyboard from the keyboard markup itself upon creation.
     *
     * @return Selective option, default false
     */
    @Deprecated
    public boolean getSelective() {
        return selective;
    }

    /**
     * Gets the ReplyMarkupType for this ReplyMarkup object
     *
     * This has been replaced with ReplyKeyboardRemove. If you wish to only hide the keyboard, you should use
     * one_time_keyboard from the keyboard markup itself upon creation.
     *
     * @return The ReplyMarkupType for this ReplyMarkup object
     */
    @Override
    @Deprecated
    public ReplyMarkupType getType() {
        return ReplyMarkupType.KEYBOARD_REMOVE;
    }

    @ToString
    private static class ReplyKeyboardHideBuilder {

        private boolean selective = false;

        private ReplyKeyboardHideBuilder() {
        }

        /**
         * *Optional*
         * Sets whether the keyboard should be selective. Use this parameter if you want to hide keyboard for specific
         * users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message
         * is a reply (has reply_to_message_id), sender of the original message.
         *
         * This has been replaced with ReplyKeyboardRemove. If you wish to only hide the keyboard, you should use
         * one_time_keyboard from the keyboard markup itself upon creation.
         *
         * @param selective True if the keyboard is selective, otherwise False
         *
         * @return The builder object
         */
        @Deprecated
        public ReplyKeyboardHideBuilder selective(boolean selective) {

            this.selective = selective;
            return this;
        }

        /**
         * Builds the ReplyKeyboardHide object
         *
         * This has been replaced with ReplyKeyboardRemove. If you wish to only hide the keyboard, you should use
         * one_time_keyboard from the keyboard markup itself upon creation.
         *
         * @return A ReplyKeyboardHide object based on the previously provided values
         */
        @Deprecated
        public ReplyKeyboardHide build() {

            return new ReplyKeyboardHide(this);
        }
    }
}