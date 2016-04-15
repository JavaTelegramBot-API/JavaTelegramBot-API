package pro.zackpollard.telegrambot.api.internal.chat.inline;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.inline.InlineCallbackQuery;
import pro.zackpollard.telegrambot.api.internal.chat.CallbackQueryImpl;

/**
 * @author zackp
 */
public class InlineCallbackQueryImpl extends CallbackQueryImpl implements InlineCallbackQuery {

    private final String inline_message_id;

    private InlineCallbackQueryImpl(JSONObject jsonObject) {

        super(jsonObject);

        this.inline_message_id = jsonObject.getString("inline_message_id");
    }

    public static InlineCallbackQuery createInlineCallbackQuery(JSONObject jsonObject) {

        return jsonObject != null ? new InlineCallbackQueryImpl(jsonObject) : null;
    }

    @Override
    public String getInlineMessageId() {
        return inline_message_id;
    }
}
