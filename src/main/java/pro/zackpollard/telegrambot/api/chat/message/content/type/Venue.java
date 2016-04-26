package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author zackp
 */
public interface Venue {

    Location getLocation();

    String getTitle();

    String getAddress();

    String getFoursquareId();
}
