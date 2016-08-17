package pro.zackpollard.telegrambot.api.chat.message.send;

/**
 * @author Zack Pollard
 */
public enum ParseMode {

    NONE(""),
    MARKDOWN("Markdown"),
    HTML("HTML");

    private final String modeName;

    ParseMode(String parseMode) {

        this.modeName = parseMode;
    }

    /**
     * Gets the mode name that telegram uses within its API to convert the enum for use with the HTTP API
     *
     * @return The telegram HTTP API version of the enum
     */
    public String getModeName() {

        return modeName;
    }
}
