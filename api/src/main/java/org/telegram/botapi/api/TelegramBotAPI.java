package org.telegram.botapi.api;

import lombok.Getter;
import org.telegram.botapi.api.managers.FileManager;

import java.util.logging.Level;

/**
 * @author Zack Pollard
 */
public final class TelegramBotAPI {

    @Getter
    private static BotServer botServer;

    static BotServer getServer() {

        return botServer;
    }

    public static void setServer(BotServer botServer) {

        if(TelegramBotAPI.botServer != null) {

            throw new UnsupportedOperationException("Cannot redefine singleton BotServer");
        }

        TelegramBotAPI.botServer = botServer;
        botServer.getLogger().log(Level.INFO, "This server is running " + getName() + " version " + getVersion());
    }

    public static String getName() {
        return botServer.getName();
    }

    public static String getVersion() {
        return botServer.getVersion();
    }

    public static FileManager getFileManager() {

        return botServer.getFileManager();
    }
}