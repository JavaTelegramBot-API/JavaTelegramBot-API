package pro.zackpollard.telegrambot.api.stickers;

public enum MaskPoint {

    CHIN("chin"),
    EYES("eyes"),
    FOREHEAD("forehead"),
    MOUTH("mouth");

    private final String value;

    MaskPoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * Gets the MaskPoint relating to the value that is passed to the function
     *
     * @param value The value you want to match to a MaskPoint
     *
     * @return The MaskPoint relating to the value, will be null if no matches are found
     */
    public static MaskPoint getType(String value) {

        for (MaskPoint v : values()) {

            if (v.getValue().equalsIgnoreCase(value)) {

                return v;
            }
        }

        return null;
    }
}