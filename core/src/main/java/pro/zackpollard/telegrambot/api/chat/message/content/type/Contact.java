package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Contact {

    /**
     * Gets the phone number for the contact
     *
     * @return The phone number for the contact
     */
    String getPhoneNumber();

    /**
     * Gets the first name of the contact
     *
     * @return The first name of the contact
     */
    String getFirstName();

    /**
     * Gets the last name of the contact, can be null
     *
     * @return The last name of the contact or null if no last name is set
     */
    String getLastName();

    /**
     * Gets the full name of the contact
     *
     * @return The full name of the contact
     */
    default String getFullName() {

        String fullName = getFirstName();

        if (getLastName() != null) {

            fullName += " " + getLastName();
        }

        return fullName;
    }

    /**
     * Gets the user id of the contact
     *
     * @return The user id of the contact
     */
    int getUserId();
}
