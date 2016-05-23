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

    public String getValue() {
        return value;
    }

    public static ChatMemberStatus getType(String value) {

        for (ChatMemberStatus v : values()) {

            if (v.getValue().equalsIgnoreCase(value)) {

                return v;
            }
        }

        return ChatMemberStatus.UNKNOWN;
    }
}
