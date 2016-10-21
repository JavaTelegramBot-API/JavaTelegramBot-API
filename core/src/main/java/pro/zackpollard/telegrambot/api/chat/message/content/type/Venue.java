package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author zackp
 */
public interface Venue {

    /**
     * Gets the location of the venue
     *
     * @return The location of the venue
     */
    Location getLocation();

    /**
     * Gets the name of the venue
     *
     * @return The name of the venue
     */
    String getTitle();

    /**
     * Gets the address of the venue
     *
     * @return The address of the venue
     */
    String getAddress();

    /**
     * Gets the foursquare ID relating to this venue, can be null
     *
     * @return The foursquare ID relating to this venue or null if no foursquare ID was sent
     */
    String getFoursquareId();
}
