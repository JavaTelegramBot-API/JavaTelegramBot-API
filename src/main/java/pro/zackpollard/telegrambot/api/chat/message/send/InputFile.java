package pro.zackpollard.telegrambot.api.chat.message.send;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.Getter;
import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.internal.FileExtension;
import pro.zackpollard.telegrambot.api.internal.managers.FileManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;

/**
 * @author Zack Pollard
 */
public class InputFile {

	@Getter
	private final String fileID;
	@Getter
	private final File file;

	public InputFile(URL url) {

		File file = TelegramBot.getFileManager().getFile(url);
		if (file == null) {
			try {
				String stringifiedUrl = url.toExternalForm();
				HttpResponse<InputStream> response = Unirest.get(stringifiedUrl).asBinary();
				String extension = FileExtension.getByMimeType(response.getHeaders().getFirst("content-type"));
				if (extension == null) {
					extension = stringifiedUrl.substring(stringifiedUrl.lastIndexOf('.') + 1);
					if (extension.length() > 4) {
						extension = null; // Default to .tmp if there was no valid extension
					}
				}
				file = File.createTempFile("jtb-"+System.currentTimeMillis(), extension, FileManager.getTemporaryFolder());
				file.deleteOnExit();
				TelegramBot.getFileManager().cacheUrl(url, file);
				Files.copy(response.getRawBody(), file.toPath());
			} catch (UnirestException | IOException ex) {
				ex.printStackTrace();
			}
		}
		this.file = file;
		this.fileID = TelegramBot.getFileManager().getFileID(file);
	}

	public InputFile(File file) {

		this.file = file;
		this.fileID = TelegramBot.getFileManager().getFileID(file);
	}

	public InputFile(String fileID) {

		this.file = null;
		this.fileID = fileID;
	}
}