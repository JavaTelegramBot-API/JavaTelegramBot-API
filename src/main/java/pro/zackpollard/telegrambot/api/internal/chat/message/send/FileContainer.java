package pro.zackpollard.telegrambot.api.internal.chat.message.send;

import pro.zackpollard.telegrambot.api.chat.message.send.InputFile;

import java.io.File;

/**
 * @author Zack Pollard
 */
public class FileContainer extends File {

    private final InputFile inputFile;

    public FileContainer(InputFile inputFile) {

        super(inputFile.getFile().toURI());

        this.inputFile = inputFile;
    }

    @Override
    public String getName() {

        return inputFile.getFileName();
    }
}