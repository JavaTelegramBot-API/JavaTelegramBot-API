package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.content.PinnedMessageContent;
import pro.zackpollard.telegrambot.api.internal.chat.message.MessageImpl;

import static java.awt.SystemColor.text;

/**
 * @author Zack Pollard
 */
public class PinnedMessageContentImpl implements PinnedMessageContent {

    private final Message content;

    private PinnedMessageContentImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.content = MessageImpl.createMessage(jsonObject, telegramBot);
    }

    public static PinnedMessageContent createPinnedMessageContent(JSONObject jsonObject, TelegramBot telegramBot) {

        return text != null ? new PinnedMessageContentImpl(jsonObject, telegramBot) : null;
    }

    @Override
    public Message getContent() {
        return content;
    }
}
