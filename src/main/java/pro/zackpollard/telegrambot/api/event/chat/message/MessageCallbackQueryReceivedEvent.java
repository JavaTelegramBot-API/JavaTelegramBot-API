package pro.zackpollard.telegrambot.api.event.chat.message;

import pro.zackpollard.telegrambot.api.chat.message.MessageCallbackQuery;
import pro.zackpollard.telegrambot.api.event.chat.CallbackQueryReceivedEvent;

/**
 * @author zackp
 */
public class MessageCallbackQueryReceivedEvent extends CallbackQueryReceivedEvent {

    public MessageCallbackQueryReceivedEvent(MessageCallbackQuery messageCallbackQuery) {

        super(messageCallbackQuery);
    }

    public MessageCallbackQuery getCallbackQuery() {

        return (MessageCallbackQuery) callbackQuery;
    }
}
