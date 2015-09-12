package org.telegram.botapi.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Contact {

    String getPhoneNumber();

    String getFirstName();

    String getLastName();

    default String getFullName() {

        return getFirstName() + " " + getLastName();
    }

    int getUserId();
}
