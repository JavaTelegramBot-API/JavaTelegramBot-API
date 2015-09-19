package org.telegram.botapi.api.chat.message.content.type;

/**
 * @author Zack Pollard
 */
public interface Document extends File, Mimetypeable, Thumbnailable {

    String getFileName();
}
