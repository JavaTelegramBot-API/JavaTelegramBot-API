package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.PhotoContent;
import pro.zackpollard.telegrambot.api.chat.message.content.type.PhotoSize;
import pro.zackpollard.telegrambot.api.internal.chat.message.content.type.PhotoSizeImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class PhotoContentImpl implements PhotoContent {

    private final PhotoSize[] content;
    private final String caption;

    private PhotoContentImpl(JSONArray jsonArray, String caption) {

        List<PhotoSize> photoSizeList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); ++i) {

            JSONObject photoObject = jsonArray.getJSONObject(i);
            photoSizeList.add(PhotoSizeImpl.createPhotoSize(photoObject));
        }

        content = photoSizeList.stream()
                .toArray(PhotoSize[]::new);

        this.caption = caption;
    }

    public static PhotoContent createPhotoContent(JSONArray jsonArray, String caption) {

        return jsonArray != null ? new PhotoContentImpl(jsonArray, caption) : null;
    }

    @Override
    public PhotoSize[] getContent() {
        return content;
    }

    @Override
    public String getCaption() {
        return caption;
    }
}