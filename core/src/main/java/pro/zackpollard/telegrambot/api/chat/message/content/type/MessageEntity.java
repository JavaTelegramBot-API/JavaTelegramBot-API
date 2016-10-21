package pro.zackpollard.telegrambot.api.chat.message.content.type;

import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author zackp
 */
public interface MessageEntity {

    /**
     * Gets the MessageEntityType that this MessageEntity relates to.
     *
     * Can be mention (@username), hashtag, bot_command, url, email, bold (bold text), italic (italic text),
     * code (monowidth string), pre (monowidth block), text_link (for clickable text URLs),
     * text_mention (for users without usernames)
     *
     * @return The MessageEntityType of this MessageEntity
     */
    MessageEntityType getType();

    /**
     * Gets the offset in UTF-16 code units to the start of the entity
     *
     * @return The offset to the start of the entity
     */
    int getOffset();

    /**
     * Gets the length of the entity in UTF-16 code units
     *
     * @return The length of the entity
     */
    int getLength();

    /**
     * Gets the URL that the MessageEntity refers to. For "text_link" only, urlthat will be opened after user taps on
     * the text. Can be null
     *
     * @return The URL that the MessageEntity refers to or null if the MessageEntityType isn't a TEXT_LINK
     */
    String getUrl();

    /**
     * Gets the User that the MessageEntity refers to. For "text_mention" only. Can be null
     *
     * @return The User that the MessageEntity refers to or null if the MessageEntityType isn't TEXT_MENTION
     */
    User getUser();
}
