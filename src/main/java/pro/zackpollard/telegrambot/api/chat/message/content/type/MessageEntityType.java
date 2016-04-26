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
    UNKNOWN("unknown");

    private String value;

    MessageEntityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MessageEntityType getType(String value) {

        for (MessageEntityType v : values()) {

            if (v.getValue().equalsIgnoreCase(value)) {

                return v;
            }
        }

        return MessageEntityType.UNKNOWN;
    }
}
