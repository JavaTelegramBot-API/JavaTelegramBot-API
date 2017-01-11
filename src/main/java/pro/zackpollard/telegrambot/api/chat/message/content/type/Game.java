package pro.zackpollard.telegrambot.api.chat.message.content.type;

import java.util.List;

/**
 * @author Zack Pollard
 */
public interface Game {

    /**
     * Gets the title of the game
     *
     * @return The title of the game
     */
    String getTitle();

    /**
     * Gets the description of the game
     *
     * @return The description of the game
     */
    String getDescription();

    /**
     * Gets an array of PhotoSize objects relating to the photo that will be sent with the game message in chats
     *
     * @return An array of PhotoSize objects for the photo of the game
     */
    PhotoSize[] getPhotos();

    /**
     * Gets the text that was sent with the Game or null if not set
     *
     * @return The text that was sent with the Game or null if not set
     */
    String getText();

    /**
     * Gets the Animation that was sent with the Game or null if not sent
     *
     * @return The Animation that was sent with the Game or null if not set
     */
    Animation getAnimation();

    /**
     * Gets the list of MessageEntity objects that this GameContents text contains
     *
     * @return A List of MessageEntity objects
     */
    List<MessageEntity> getTextEntities();
}