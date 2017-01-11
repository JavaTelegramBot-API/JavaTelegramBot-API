package pro.zackpollard.telegrambot.api.games;

import pro.zackpollard.telegrambot.api.chat.message.Message;

/**
 * @author Zack Pollard
 */
public interface GameScoreEditResponse {

    /**
     * Will only be populated if getResponse() is true, and the message being edited wasn't inline and was sent by
     * the bot
     *
     * @return The message being edited by the bot, or null if the pre-conditions were not satisfied
     */
    Message getMessage();

    /**
     * Whether the edit succeeded or failed
     *
     * @return Whether the edit succeeded or failed
     */
    boolean getResponse();
}
