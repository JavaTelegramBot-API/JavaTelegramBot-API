package org.telegram.botapi.api;

import org.telegram.botapi.api.managers.FileManager;

import java.util.logging.Logger;

/**
 * @author Zack Pollard
 */
public interface BotServer {

    Logger getLogger();

    String getName();
    String getVersion();

    FileManager getFileManager();
}