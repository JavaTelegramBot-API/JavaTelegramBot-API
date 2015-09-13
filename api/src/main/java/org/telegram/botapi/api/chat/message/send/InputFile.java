package org.telegram.botapi.api.chat.message.send;

/**
 * @author Zack Pollard
 */
public interface InputFile {

    String getId();
    String getFilePath();

    @Override
    boolean equals(Object object);
}
