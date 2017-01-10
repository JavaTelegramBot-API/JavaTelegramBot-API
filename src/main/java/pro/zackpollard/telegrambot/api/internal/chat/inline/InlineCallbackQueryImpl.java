package pro.zackpollard.telegrambot.api.internal.chat.inline;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.inline.InlineCallbackQuery;
import pro.zackpollard.telegrambot.api.internal.chat.CallbackQueryImpl;

/**
 * @author zackp
 */
public class InlineCallbackQueryImpl extends CallbackQueryImpl implements InlineCallbackQuery {

    private final String inline_message_id;

    protected InlineCallbackQueryImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        super(jsonObject, telegramBot);

        this.inline_message_id = jsonObject.getString("inline_message_id");
    }

    public static InlineCallbackQuery createInlineCallbackQuery(JSONObject jsonObject, TelegramBot telegramBot) {

        return jsonObject != null ? new InlineCallbackQueryImpl(jsonObject, telegramBot) : null;
    }

    @Override
    public String getInlineMessageId() {
        return inline_message_id;
    }
}
