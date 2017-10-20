package pro.zackpollard.telegrambot.api.internal.stickers;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.stickers.MaskPoint;
import pro.zackpollard.telegrambot.api.stickers.MaskPosition;

public class MaskPositionImpl {

    public static MaskPosition createMaskPosition(JSONObject jsonObject) {

        if(jsonObject != null) {

            MaskPoint point = MaskPoint.getType(jsonObject.getString("point"));
            double x_shift = jsonObject.getDouble("x_shift");
            double y_shift = jsonObject.getDouble("y_shift");
            double scale = jsonObject.getDouble("scale");

            return MaskPosition.builder()
                    .point(point)
                    .xShift(x_shift)
                    .yShift(y_shift)
                    .scale(scale).build();
        }

        return null;
    }
}
