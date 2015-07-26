package org.telegram.javabotapi.api.keyboards;

/**
 * @author Zack Pollard
 */
public interface ReplyKeyboardHide extends Keyboard {

    default boolean getHideKeyboard() {

        return true;
    }
}
