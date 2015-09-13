package org.telegram.botapi.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Contact {

    String getPhoneNumber();

    String getFirstName();

    String getLastName();

    default String getFullName() {

        String fullName = getFirstName();

        if(getLastName() != null) {

            fullName += " " + getLastName();
        }

        return fullName;
    }

    int getUserId();
}
