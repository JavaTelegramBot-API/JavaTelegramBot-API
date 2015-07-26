package org.telegram.javabotapi.api.keyboards;

import org.telegram.javabotapi.api.chat.message.ReplyMarkup;

/**
 * @author Zack Pollard
 */
public interface ReplyKeyboardHide extends Keyboard {

    default boolean getHideKeyboard() {

        return true;
    }
}
