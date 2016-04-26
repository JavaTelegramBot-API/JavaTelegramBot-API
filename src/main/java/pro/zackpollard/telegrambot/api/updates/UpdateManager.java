package pro.zackpollard.telegrambot.api.updates;

import pro.zackpollard.telegrambot.api.TelegramBot;

/**
 * @author Zack Pollard
 */
public abstract class UpdateManager {

    private final TelegramBot telegramBot;

    protected UpdateManager(TelegramBot telegramBot) {

        this.telegramBot = telegramBot;
    }

    public TelegramBot getBotInstance() {
        return telegramBot;
    }

    public enum UpdateMethod {

        REQUEST_UPDATES,
        WEBHOOK
    }

    public abstract UpdateMethod getUpdateMethod();
}