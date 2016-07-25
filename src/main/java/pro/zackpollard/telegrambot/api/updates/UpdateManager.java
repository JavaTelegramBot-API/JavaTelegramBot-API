package pro.zackpollard.telegrambot.api.updates;

import pro.zackpollard.telegrambot.api.TelegramBot;

/**
 * @author Zack Pollard
 */
public abstract class UpdateManager {

    private final TelegramBot telegramBot;
    protected boolean running = false;

    protected UpdateManager(TelegramBot telegramBot) {

        this.telegramBot = telegramBot;
    }

    public TelegramBot getBotInstance() {
        return telegramBot;
    }

    public abstract void stopUpdates();

    public abstract boolean startUpdates();

    public boolean isRunning() {

        return this.running;
    }

    public enum UpdateMethod {

        REQUEST_UPDATES,
        WEBHOOK
    }

    public abstract UpdateMethod getUpdateMethod();
}