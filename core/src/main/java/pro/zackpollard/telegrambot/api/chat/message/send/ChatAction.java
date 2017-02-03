package pro.zackpollard.telegrambot.api.chat.message.send;

/**
 * @author Zack Pollard
 */
public enum ChatAction {

    TYPING_TEXT_MESSAGE("typing"),
    UPLOADING_PHOTO("upload_photo"),
    RECORDING_VIDEO("record_video"),
    UPLOADING_VIDEO("upload_video"),
    RECORD_AUDIO("record_audio"),
    UPLOAD_AUDIO("upload_audio"),
    UPLOAD_DOCUMENT("upload_document"),
    FIND_LOCATION("find_location");

    private final String name;

    ChatAction(String name) {

        this.name = name;
    }

    /**
     * Gets the version of the name that telegram uses in its API
     *
     * @return The telegram API version of the name
     */
    public String getName() {

        return name;
    }
}
