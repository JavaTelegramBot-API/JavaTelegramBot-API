package pro.zackpollard.telegrambot.api.internal.chat.message.content.type;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zack Pollard
 */
public class GameImpl implements Game {

    private final String title;
    private final String description;
    private final PhotoSize[] photo;
    private final String text;
    private final List<MessageEntity> text_entities;
    private final Animation animation;

    private GameImpl(JSONObject jsonObject) {

        this.title = jsonObject.getString("title");
        this.description = jsonObject.getString("description");

        List<PhotoSize> photoSizeList = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("photo");

        for (int i = 0; i < jsonArray.length(); ++i) {

            JSONObject photoObject = jsonArray.getJSONObject(i);
            photoSizeList.add(PhotoSizeImpl.createPhotoSize(photoObject));
        }

        photo = photoSizeList.stream()
                .toArray(PhotoSize[]::new);

        text = jsonObject.optString("text");

        this.text_entities = new LinkedList<>();

        JSONArray entities = jsonObject.optJSONArray("text_entities");

        if(entities != null) {

            for (int i = 0; i < entities.length(); ++i) {

                MessageEntity messageEntity = MessageEntityImpl.createMessageEntity(entities.getJSONObject(i));

                if (messageEntity != null) {

                    this.text_entities.add(messageEntity);
                }
            }
        }

        this.animation = AnimationImpl.createAnimation(jsonObject.optJSONObject("animation"));
    }

    public static Game createGame(JSONObject jsonObject) {

        return jsonObject != null ? new GameImpl(jsonObject) : null;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public PhotoSize[] getPhotos() {
        return this.photo;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public Animation getAnimation() {
        return this.animation;
    }

    @Override
    public List<MessageEntity> getTextEntities() {
        return this.text_entities;
    }
}
