package org.telegram.javabotapi.api.chat.message;

/**
 * @author Zack Pollard
 */
public interface ReplyMarkup {

    /**
     * Gets whether the keyboard will only show for selected users
     * Targets: 1) users that are @mentioned in the text of the Message object;
     * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     *
     * @return Selective option, default false
     */
    boolean getSelective();
}
