package pro.zackpollard.telegrambot.api.games;

import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public interface GameHighScore {

    long getPosition();
    User getUser();
    long getScore();
}
