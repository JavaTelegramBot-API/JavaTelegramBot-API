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

    public String getModeName() {

        return modeName;
    }
}
