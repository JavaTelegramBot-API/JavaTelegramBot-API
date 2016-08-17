package pro.zackpollard.telegrambot.api.chat.message.send;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.io.FilenameUtils;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.internal.FileExtension;
import pro.zackpollard.telegrambot.api.internal.managers.FileManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * @author Zack Pollard
 */
@ToString
public class InputFile {

    @Getter
    private final String fileID;
    @Getter
    private final File file;
    @Getter
    private final String fileName;

    /**
     * Create an InputFile object based on an external URL to be sent within a SendableMessage
     *
     * @param url The URL of the file you want this InputFile to point to
     */
    public InputFile(URL url) {

        File file = TelegramBot.getFileManager().getFile(url);
        String extension = null;
        if (file == null) {
            try {
                String stringifiedUrl = url.toExternalForm();
                HttpResponse<InputStream> response = Unirest.get(stringifiedUrl).asBinary();
                extension = FileExtension.getByMimeType(response.getHeaders().getFirst("content-type"));
                if (extension == null) {
                    extension = stringifiedUrl.substring(stringifiedUrl.lastIndexOf('.') + 1);

                    int variableIndex = extension.indexOf('?');
                    if (variableIndex > 0) extension = extension.substring(0, variableIndex);

                    if (extension.length() > 4) {
                        extension = null; // Default to .tmp if there was no valid extension
                    }
                }
                file = File.createTempFile("jtb-" + System.currentTimeMillis(), "." + extension, FileManager.getTemporaryFolder());
                file.deleteOnExit();
                TelegramBot.getFileManager().cacheUrl(url, file);
                Files.copy(response.getRawBody(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (UnirestException | IOException ex) {
                ex.printStackTrace();
            }
        }
        this.fileName = FilenameUtils.getBaseName(url.toString()) + "." + extension;
        this.file = file;
        this.fileID = TelegramBot.getFileManager().getFileID(file);
    }

    /**
     * Create an InputFile object based on a File object to be sent within a SendableMessage
     *
     * @param file A File object relating to the file you want this InputFile to point to
     */
    public InputFile(File file) {

        this.file = file;
        this.fileName = file.getName();
        this.fileID = TelegramBot.getFileManager().getFileID(file);
    }

    /**
     * Creates an InputFile object based on a File ID for a file that is stored on the telegram servers, which can
     * then be sent within a SendableMessage
     *
     * @param fileID The ID of the file stored on the telegram servers
     */
    public InputFile(String fileID) {

        this.file = null;
        this.fileName = null;
        this.fileID = fileID;
    }
}