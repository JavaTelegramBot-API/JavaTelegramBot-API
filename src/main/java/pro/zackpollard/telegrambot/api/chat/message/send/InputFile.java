package pro.zackpollard.telegrambot.api.chat.message.send;

import lombok.Getter;
import pro.zackpollard.telegrambot.api.TelegramBot;

import java.io.File;

/**
 * @author Zack Pollard
 */
public class InputFile {

	@Getter
	private final String fileID;
	@Getter
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