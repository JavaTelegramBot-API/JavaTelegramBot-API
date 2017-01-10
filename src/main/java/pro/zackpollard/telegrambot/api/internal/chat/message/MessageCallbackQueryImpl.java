package pro.zackpollard.telegrambot.api.internal.chat.message;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.MessageCallbackQuery;
import pro.zackpollard.telegrambot.api.internal.chat.CallbackQueryImpl;

/**
 * @author zackp
 */
public class MessageCallbackQueryImpl extends CallbackQueryImpl implements MessageCallbackQuery {

    private final Message message;

    private MessageCallbackQueryImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        super(jsonObject, telegramBot);

        this.message = MessageImpl.createMessage(jsonObject.getJSONObject("message"), getBotInstance());
    }

    public static MessageCallbackQuery createMessageCallbackQuery(JSONObject jsonObject, TelegramBot telegramBot) {


        return jsonObject != null ? new MessageCallbackQueryImpl(jsonObject, telegramBot) : null;
    }

    @Override
    public Message getMessage() {
        return message;
    }

    @Override
    public String getDate() {
        return super.getData();
    }
}
