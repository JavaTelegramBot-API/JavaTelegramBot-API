package pro.zackpollard.telegrambot.api.chat.message.content.type;

import java.util.List;

/**
 * @author Zack Pollard
 */
public interface Game {

    /**
     * Gets the title of the audio file, can be null
     *
     * @return The title of the audio file or null if no title is set
     */
    String getTitle();

    String getDescription();

    PhotoSize[] getPhotos();

    String getText();

    Animation getAnimation();

    /**
     * Gets the list of MessageEntity objects that this GameContents text contains
     *
     * @return A List of MessageEntity objects
     */
    List<MessageEntity> getTextEntities();
}