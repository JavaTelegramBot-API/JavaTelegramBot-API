package pro.zackpollard.telegrambot.api.internal.updates;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.CallbackQuery;
import pro.zackpollard.telegrambot.api.chat.inline.ChosenInlineResult;
import pro.zackpollard.telegrambot.api.chat.inline.InlineQuery;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.internal.chat.CallbackQueryImpl;
import pro.zackpollard.telegrambot.api.internal.chat.inline.ChosenInlineResultImpl;
import pro.zackpollard.telegrambot.api.internal.chat.inline.InlineQueryImpl;
import pro.zackpollard.telegrambot.api.internal.chat.message.MessageImpl;
import pro.zackpollard.telegrambot.api.updates.Update;

/**
 * @author Zack Pollard
 */
public class UpdateImpl implements Update {

    private final int update_id;
    private final Message message;
    private final Message edited_message;
    private final Message channel_post;
    private final Message edited_channel_post;
    private final InlineQuery inline_query;
    private final ChosenInlineResult chosen_inline_result;
    private final CallbackQuery callbackQuery;
    private UpdateType updateType;

    private final TelegramBot telegramBot;

    private UpdateImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.update_id = jsonObject.getInt("update_id");

        this.message = MessageImpl.createMessage(jsonObject.optJSONObject("message"), telegramBot);
        if (message != null) updateType = UpdateType.MESSAGE;

        this.edited_message = MessageImpl.createMessage(jsonObject.optJSONObject("edited_message"), telegramBot);
        if (edited_message != null && updateType == null) updateType = UpdateType.EDITED_MESSAGE;

        this.channel_post = MessageImpl.createMessage(jsonObject.optJSONObject("channel_post"), telegramBot);
        if (channel_post != null && updateType == null) updateType = UpdateType.CHANNEL_POST;

        this.edited_channel_post = MessageImpl.createMessage(jsonObject.optJSONObject("edited_channel_post"), telegramBot);
        if (edited_channel_post != null && updateType == null) updateType = UpdateType.EDITED_CHANNEL_POST;

        this.inline_query = InlineQueryImpl.createInlineQuery(jsonObject.optJSONObject("inline_query"));
        if (inline_query != null && updateType == null) updateType = UpdateType.INLINE_QUERY;

        this.chosen_inline_result = ChosenInlineResultImpl.createChosenInlineResult(jsonObject.optJSONObject("chosen_inline_result"));
        if (chosen_inline_result != null && updateType == null) updateType = UpdateType.CHOSEN_INLINE_RESULT;

        this.callbackQuery = CallbackQueryImpl.createCallbackQuery(jsonObject.optJSONObject("callback_query"), telegramBot);
        if (callbackQuery != null && updateType == null) updateType = UpdateType.CALLBACK_QUERY;

        this.telegramBot = telegramBot;
    }

    public static Update createUpdate(JSONObject jsonObject, TelegramBot telegramBot) {

        return new UpdateImpl(jsonObject, telegramBot);
    }

    @Override
    public int getId() {
        return update_id;
    }

    @Override
    public Message getMessage() {
        return message;
    }

    public Message getEditedMessage() {
        return edited_message;
    }

    @Override
    public Message getChannelPost() {
        return channel_post;
    }

    @Override
    public Message getEditedChannelPost() {
        return edited_channel_post;
    }

    @Override
    public InlineQuery getInlineQuery() {
        return inline_query;
    }

    @Override
    public ChosenInlineResult getChosenInlineResult() {
        return chosen_inline_result;
    }

    @Override
    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }

    @Override
    public UpdateType getType() {
        return updateType;
    }

    @Override
    public TelegramBot getBotInstance() {
        return telegramBot;
    }
}
