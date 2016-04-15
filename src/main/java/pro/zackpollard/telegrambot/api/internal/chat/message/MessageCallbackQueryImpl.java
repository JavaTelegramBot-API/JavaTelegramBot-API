package pro.zackpollard.telegrambot.api.internal.chat.message;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.MessageCallbackQuery;
import pro.zackpollard.telegrambot.api.internal.chat.CallbackQueryImpl;

/**
 * @author zackp
 */
public class MessageCallbackQueryImpl extends CallbackQueryImpl implements MessageCallbackQuery {

    private final Message message;

    private MessageCallbackQueryImpl(JSONObject jsonObject) {

        super(jsonObject);

        this.message = MessageImpl.createMessage(jsonObject.getJSONObject("message"));
    }

    public static MessageCallbackQuery createMessageCallbackQuery(JSONObject jsonObject) {

        return jsonObject != null ? new MessageCallbackQueryImpl(jsonObject) : null;
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
