package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.IndividualChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.exception.TelegramApiException;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public class IndividualChatImpl implements IndividualChat {

    private final User partner;

    private final TelegramBot telegramBot;

    private IndividualChatImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.partner = UserImpl.createUser(jsonObject);
        this.telegramBot = telegramBot;
    }

    private IndividualChatImpl(int userID, TelegramBot telegramBot) {

        this.partner = UserImpl.createUser(userID);
        this.telegramBot = telegramBot;
    }

    public static IndividualChat createIndividualChat(JSONObject jsonObject, TelegramBot telegramBot) {

        return new IndividualChatImpl(jsonObject, telegramBot);
    }

    public static Chat createIndividualChat(int chatID, TelegramBot telegramBot) {

        return new IndividualChatImpl(chatID, telegramBot);
    }

    @Override
    public User getPartner() {

        return partner;
    }

    @Override
    public TelegramBot getBotInstance() {
        return telegramBot;
    }

    @Override
    public String getId() {

        return String.valueOf(partner.getId());
    }

    @Override
    public String getName() {
        return partner.getFullName();
    }

    @Override
    public Message sendMessage(SendableMessage message) throws TelegramApiException {

        return telegramBot.sendMessage(this, message);
    }
}