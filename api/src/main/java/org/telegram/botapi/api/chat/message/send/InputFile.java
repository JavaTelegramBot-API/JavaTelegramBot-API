package org.telegram.botapi.api.chat.message.send;

import org.telegram.botapi.api.TelegramBot;

import java.io.File;

/**
 * @author Zack Pollard
 */
public class InputFile {

    private final String fileID;
    private final File file;

    public InputFile(File file) {

        this.file = file;
        this.fileID = TelegramBot.getFileManager().getFileID(file);
    }

    public InputFile(String fileID) {

        this.file = null;
        this.fileID = fileID;
    }
}