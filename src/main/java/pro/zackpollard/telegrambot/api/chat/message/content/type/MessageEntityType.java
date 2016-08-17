package pro.zackpollard.telegrambot.api.chat.message.content.type;

/**
 * @author zackp
 */
public enum MessageEntityType {

    MENTION("mention"),
    HASHTAG("hashtag"),
    BOT_COMMAND("bot_command"),
    URL("url"),
    EMAIL("email"),
    BOLD("bold"),
    ITALIC("italic"),
    CODE("code"),
    PRE("pre"),
    TEXT_LINK("text_link"),
    TEXT_MENTION("text_mention"),
    UNKNOWN("unknown");

    private String value;

    MessageEntityType(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the enum in lowercase
     *
     * @return The value of the enum in lowercase
     */
    public String getValue() {
        return value;
    }

    /**
     * Gets the MessageEntityType relating to the value that is passed to the function
     *
     * @param value The value you want to match to a MessageEntityType
     *
     * @return The MessageEntityType relating to the value, will be MessageEntityType.UNKNOWN if no matches are found
     */
    public static MessageEntityType getType(String value) {

        for (MessageEntityType v : values()) {

            if (v.getValue().equalsIgnoreCase(value)) {

                return v;
            }
        }

        return MessageEntityType.UNKNOWN;
    }
}
