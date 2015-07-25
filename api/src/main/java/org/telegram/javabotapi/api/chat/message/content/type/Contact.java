package org.telegram.javabotapi.api.chat.message.content.type;

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
    String getUserId();
}
