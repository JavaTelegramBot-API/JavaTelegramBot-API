package pro.zackpollard.telegrambot.api.chat;

/**
 * @author Zack Pollard
 */
public enum ChatMemberStatus {

    CREATOR("creator"),
    ADMINISTRATOR("administrator"),
    MEMBER("member"),
    LEFT("left"),
    KICKED("kicked"),
    UNKNOWN("unknown");

    private String value;

    ChatMemberStatus(String value) {
        this.value = value;
    }

    /**
     * Gets the Telegram Bot API version of this enum
     *
     * @return The Telegram Bot API version of this enum
     */
    public String getValue() {
        return value;
    }

    /**
     * Get a ChatMemberStatus enum based on the provided string value
     *
     * @param value The value you want to match a ChatMemberStatus to
     *
     * @return The ChatMemberStatus that matches the value provided, ignoring case. UNKNOWN if no matches are found
     */
    public static ChatMemberStatus getType(String value) {

        for (ChatMemberStatus v : values()) {

            if (v.getValue().equalsIgnoreCase(value)) {

                return v;
            }
        }

        return ChatMemberStatus.UNKNOWN;
    }
}
