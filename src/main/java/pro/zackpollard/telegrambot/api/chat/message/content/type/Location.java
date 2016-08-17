package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Location {

    /**
     * Gets the longitude of the sent Location
     *
     * @return The longitude of the location
     */
    double getLongitude();

    /**
     * Gets the latitude of the sent Location
     *
     * @return The latitude of the location
     */
    double getLatitude();
}
