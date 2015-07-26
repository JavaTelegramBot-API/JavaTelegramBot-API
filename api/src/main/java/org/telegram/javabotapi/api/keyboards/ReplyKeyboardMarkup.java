package org.telegram.javabotapi.api.keyboards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public interface ReplyKeyboardMarkup extends Keyboard {

    /**
     * Gets Array of button rows, each represented by an Array of Strings
     *
     * @return Button rows
     */
    List<List<String>> getButtons();

    /**
     * Add a new row to the keyboard
     *
     * @param cellValues The values for the new row
     * @return The keyboard object
     */
    default ReplyKeyboardMarkup addRow(String... cellValues) {

        List<String> list = new LinkedList<>();

        Collections.addAll(list, cellValues);
        return addRow(list);
    }

    /**
     * Add a new row to the keyboard
     *
     * @param cellValues The values for the new row
     * @return The keyboard object
     */
    default ReplyKeyboardMarkup addRow(List<String> cellValues) {

        getButtons().add(cellValues);
        return this;
    }

    /**
     * Sets a row of the keyboard
     *
     * @param cellValues The values for the row
     * @return The keyboard object
     */
    default ReplyKeyboardMarkup setRow(int row, String... cellValues) throws ArrayIndexOutOfBoundsException {

        List<String> list = new LinkedList<>();

        Collections.addAll(list, cellValues);
        return setRow(row, list);
    }

    /**
     * Sets a row of the keyboard
     *
     * @param row        The index of the row
     * @param cellValues The values for the row
     * @return The keyboard object
     */
    default ReplyKeyboardMarkup setRow(int row, List<String> cellValues) throws ArrayIndexOutOfBoundsException {

        getButtons().get(row).clear();
        getButtons().get(row).addAll(cellValues);
        return this;
    }

    /**
     * Sets a cell of the keyboard
     *
     * @param row       The index of the row
     * @param column    The index of the column
     * @param cellValue The value for the cell
     * @return The keyboard object
     */
    default ReplyKeyboardMarkup setCell(int row, int column, String cellValue) throws ArrayIndexOutOfBoundsException {

        getButtons().get(row).set(column, cellValue);
        return this;
    }

    /**
     * Gets whether the keyboard should be resized on the client for optimal vertical fit
     *
     * @return Resize option, default false
     */
    boolean getResize();

    /**
     * Gets whether the keyboard is one-time i.e. will vanish after it has been used
     *
     * @return One-time option, default false
     */
    boolean getOneTime();
}
