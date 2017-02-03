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

    /**
     * Gets the TelegramBot instance that this UpdateManager is responsible for
     *
     * @return The TelegramBot instance that this UpdateManager is responsible for
     */
    public TelegramBot getBotInstance() {
        return telegramBot;
    }

    /**
     * Use this to stop the UpdateManager from running
     */
    public abstract void stopUpdates();

    /**
     * Use this to start the UpdateManager and begin receiving Updates
     *
     * @return True if the UpdateManager was started successfully, otherwise False
     */
    public abstract boolean startUpdates();

    /**
     * Gets whether the UpdateManager is currently running
     *
     * @return True if the UpdateManager is running, otherwise False
     */
    public boolean isRunning() {

        return this.running;
    }
}