package pro.zackpollard.telegrambot.api.internal;

import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum FileExtension {

    // TODO: add more mime types?
    UNKNOWN(""),
    JPG("jpg", "image/jpeg"),
    PNG("png", "image/png"),
    GIF("gif", "image/gif"),
    MP4("mp4", "video/mp4"),
    MOV("mov", "video/quicktime"),
    MP3("mp3", "audio/mp3"),
    AVI("avi", "video/avi"),
    MKV("mkv", "video/x-matroska");

    @Getter
    private final String extension;

    @Getter
    private final String[] mimeTypes;

    private static final Map<String, FileExtension> byMimeType;

    FileExtension(String extension, String... mimeTypes) {
        this.extension = extension;
        this.mimeTypes = mimeTypes;
    }

    static {
        Map<String, FileExtension> map = new HashMap<>();
        for (FileExtension ext : values()) {
            for (String mimeType : ext.getMimeTypes()) {
                map.put(mimeType, ext);
            }
        }
        byMimeType = Collections.unmodifiableMap(map);
    }

    public static String getByMimeType(String mimeType) {
        if (mimeType == null) {
            return null;
        }
        // If I recall correctly, there's a + separator used by some mime types, to append extra metadata such as versions
        int index = mimeType.indexOf('+');
        if (index > 0) {
            mimeType = mimeType.substring(0, index);
        }
        return Optional.ofNullable(FileExtension.byMimeType.get(mimeType)).map(FileExtension::getExtension).orElse(null);
    }
}