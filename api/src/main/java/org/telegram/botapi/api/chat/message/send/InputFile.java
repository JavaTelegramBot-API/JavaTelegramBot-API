package org.telegram.botapi.api.chat.message.send;

/**
 * @author Zack Pollard
 */
public interface InputFile {

    int getId();
    String getFilePath();
    byte[] getFileHash();

    @Override
    boolean equals(Object object);
}
