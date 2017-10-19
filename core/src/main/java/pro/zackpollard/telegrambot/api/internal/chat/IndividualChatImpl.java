package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.chat.Chat;
import pro.zackpollard.telegrambot.api.chat.ChatPhoto;
import pro.zackpollard.telegrambot.api.chat.IndividualChat;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public class IndividualChatImpl implements IndividualChat {

    private final User partner;
    private final ChatPhoto photo;

    private final TelegramBot telegramBot;

    private IndividualChatImpl(JSONObject jsonObject, TelegramBot telegramBot) {

        this.partner = UserImpl.createUser(jsonObject);
        this.photo = ChatPhotoImpl.createChatPhoto(jsonObject.optJSONObject("photo"));
        this.telegramBot = telegramBot;
    }

    public static IndividualChat createIndividualChat(JSONObject jsonObject, TelegramBot telegramBot) {

        return new IndividualChatImpl(jsonObject, telegramBot);
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
    public ChatPhoto getPhoto() {
        return photo;
    }

    @Override
    public Message sendMessage(SendableMessage message) {

        return telegramBot.sendMessage(this, message);
    }
}