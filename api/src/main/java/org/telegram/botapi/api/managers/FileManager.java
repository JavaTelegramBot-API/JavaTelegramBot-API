package org.telegram.botapi.api.managers;

import org.telegram.botapi.api.chat.message.send.InputFile;

import java.io.File;

/**
 * @author Zack Pollard
 */
public interface FileManager {

    InputFile uploadFile(File file);
}
